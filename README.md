# forage-midas

## Overview

This repository contains the implementation for the **JPMC Advanced Software Engineering – MIDAS** project.  
It is based on the official Forage starter project and implements a backend service using Java and Spring Boot.

The project simulates components commonly found in financial systems and is intended to demonstrate backend development, configuration, and testing practices.

---

## Project Objectives

- Implement a backend service following enterprise-style architecture
- Apply Java and Spring Boot in a real-world style project
- Complete the technical requirements of the JPMC Forage program
- Demonstrate clean structure, configuration, and build practices

---

## Technologies Used

- Java (JDK 11+)
- Spring Boot
- Maven
- YAML configuration
- Git

---

## Prerequisites

Ensure the following are installed before running the project:

- Java JDK 11 or later
- Maven
- Git

---

## Running the Project

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

## Project Structure

| Path | Description |
|------|-------------|
| `src/main/java` | Application source code |
| `src/test/java` | Unit tests |
| `src/main/resources` | Configuration files |
| `application.yml` | Application configuration |
| `pom.xml` | Maven build configuration |
| `.mvn/` | Maven wrapper files |

---

## Configuration

Application settings are defined in:

```
src/main/resources/application.yml
```

This file controls runtime configuration such as server settings and application options.

---

## Testing

Run all tests using:

```bash
mvn test
```

---

## Notes

This repository follows the structure and requirements of the JPMC Forage MIDAS project.  
Additional functionality can be implemented as required by the assignment or extended for learning purposes.

---

## License

This project follows the same license terms as the original Forage starter repository.
