// File: TransactionListener.java

package com.jpmc.midascore.kafka;

import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {
    public TransactionListener() {
        System.out.println("✅ TransactionListener bean created");
    }
    private static final Logger log = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core")
    public void onMessage(Transaction tx) {
        log.info("Consumed tx: {}", tx);
    }

}