# Java Hibernate CRUD Application

This project demonstrates a Java-based CRUD (Create, Read, Update, Delete) application
implemented using **Hibernate ORM** and **JPA**, with **MySQL** as the relational database.

The application showcases how to persist and manage entities using Hibernate,
including full lifecycle operations such as creating, reading, updating, and deleting records.

---

## Project Overview

The goal of this project is to demonstrate:
- Object–Relational Mapping (ORM) using Hibernate
- JPA entity mapping and annotations
- Basic database operations using the DAO pattern
- Integration of Java applications with a MySQL database

The project operates on a simple **User** entity to clearly illustrate core concepts
without unnecessary complexity.

---

## Technologies Used

- **Java 11+**
- **Hibernate 5.x**
- **MySQL 8+**
- **Maven**
- **JPA (Java Persistence API)**
- **Log4j** (logging)

---

## Project Structure

- **Entity Layer** – JPA-annotated `User` entity
- **DAO Layer** – `UserDAO` class handling all CRUD operations
- **Configuration** – Hibernate configuration via `hibernate.cfg.xml`
- **Application Entry Point** – `Main.java`

---

## Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/vasile007/java-hibernate-crud-application.git
cd java-hibernate-crud-application

2. Configure Database Connection

Edit the file src/main/resources/hibernate.cfg.xml and set your MySQL credentials:
<property name="connection.url">jdbc:mysql://localhost:3306/your_database</property>
<property name="connection.username">your_username</property>
<property name="connection.password">your_password</property>
Ensure that the specified database exists in MySQL before running the application.

3. Build the Project

mvn clean install
4. Run the Application

Run the Main.java class from your IDE or using the terminal.
Usage

The application manages a User entity with fields such as id, name, and email.
All CRUD operations are implemented through the UserDAO class.

Example CRUD Operations

// Create
User user = new User("John Doe", "john@example.com");
userDao.saveUser(user);

// Read
User retrieved = userDao.getUserById(1);

// Update
retrieved.setName("Jane Doe");
userDao.updateUser(retrieved);

// Delete
userDao.deleteUserById(1);


Purpose & Learning Outcomes

This project was created to demonstrate:

Practical use of Hibernate and JPA

Understanding of ORM concepts

Clean separation of concerns using DAO pattern

Integration of Java applications with relational databases

Basic enterprise-style application structure



