// File: TransactionListener.java
package com.jpmc.midascore.kafka;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionListener {
    private static final Logger log = LoggerFactory.getLogger(TransactionListener.class);

    private final UserRepository userRepository;
    private final TransactionRecordRepository transactionRepository;

    public TransactionListener(UserRepository userRepository, TransactionRecordRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core")
    @Transactional
    public void onMessage(Transaction tx) {
        log.info("📥 Received tx: {}", tx);

        // Fetch sender and recipient
        UserRecord sender = userRepository.findById(tx.getSenderId());
        UserRecord recipient = userRepository.findById(tx.getRecipientId());

        // Validate both users and balance
        if (sender == null || recipient == null) {
            log.warn("Invalid sender or recipient: {}", tx);
            return;
        }

        if (sender.getBalance() < tx.getAmount()) {
            log.warn("Insufficient funds: {}", tx);
            return;
        }

        // Update balances
        sender.setBalance(sender.getBalance() - tx.getAmount());
        recipient.setBalance(recipient.getBalance() + tx.getAmount());

        // Save users
        userRepository.save(sender);
        userRepository.save(recipient);

        // Create a transaction record
        TransactionRecord record = new TransactionRecord(sender, recipient, tx.getAmount());
        transactionRepository.save(record);

        log.info("Recorded tx: {} -> {} (${}) | New balances => {}: ${}, {}: ${}",
                sender.getName(),
                recipient.getName(),
                String.format("%.2f", tx.getAmount()),
                sender.getName(),
                String.format("%.2f", sender.getBalance()),
                recipient.getName(),
                String.format("%.2f", recipient.getBalance()));

    }
}
