# forage-midas

> Project repository for the **JPMC Advanced Software Engineering Forage program**  
> Forked from the official starter: *vagabond-systems/forage-midas*

---

## 🧠 About

This project implements the **MIDAS Core Simulation** as part of the **JPMC Advanced Software Engineering** virtual experience.

It simulates backend services commonly found in financial systems and is built using **Java** and **Spring Boot**.

---

## 🎯 Project Goals

- Implement a backend service based on a real-world finance use case
- Demonstrate software engineering best practices
- Complete the required Forage program tasks
- Gain experience with Java, Maven, and Spring Boot

---

## 🚀 Features

- Java-based backend application  
- Spring Boot framework  
- Maven build system  
- Configurable via `application.yml`  
- Designed for extensibility and testing  

---

## 🛠 Prerequisites

Make sure the following are installed:

- Java JDK **11 or newer**
- Maven
- Git

---

## 📦 Running the Project

Clone the repository:

```bash
git clone https://github.com/HaythamLhash/forage-midas.git
cd forage-midas
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

---

## 📁 Project Structure

| Path | Description |
|------|-------------|
| `src/` | Java source files |
| `src/main/java` | Application logic |
| `src/test/java` | Unit tests |
| `application.yml` | Application configuration |
| `pom.xml` | Maven configuration |
| `.mvn/`, `mvnw` | Maven wrapper files |

---

## ⚙ Configuration

All configuration is handled via:

```
src/main/resources/application.yml
```

You can modify settings such as:
- Server port
- Service options
- Environment values

---

## 🧪 Testing

Run all tests using:

```bash
mvn test
```

---

## 📌 Notes

This repository is based on the official JPMC Forage MIDAS starter project.  
Additional functionality should be implemented as required by the Forage tasks.

---

## 📜 License

This project follows the licensing terms of the original Forage starter repository.
