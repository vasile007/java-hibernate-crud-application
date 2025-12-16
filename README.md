# Java Hibernate CRUD Application

This is a simple **CRUD (Create, Read, Update, Delete)** application built with Java and Hibernate ORM, using MySQL as the database. It demonstrates basic operations on a `User` entity using JPA and Hibernate.

---

##  About

The project shows how to perform basic database operations using Hibernate ORM. It includes full examples of creating, reading, updating, and deleting data from a MySQL database.

---

##  Technologies Used

- Java 11+
- Hibernate 5.x
- MySQL 8+
- Maven
- JPA (Java Persistence API)
- Log4j (logging)

---

## ⚙️ Installation & Setup

1. **Clone the repository**
    ```bash
    git clone https://github.com/vasile007/java-hibernate-crud-application.git
    cd java-hibernate-crud-application
    ```

2. **Configure database connection**  
   Open `src/main/resources/hibernate.cfg.xml` and set your database credentials:
    ```xml
    <property name="connection.url">jdbc:mysql://localhost:3306/your_database</property>
    <property name="connection.username">your_username</property>
    <property name="connection.password">your_password</property>
    ```

3. **Build the project**
    ```bash
    mvn clean install
    ```

4. **Run the application**  
   Run the `Main.java` class from your IDE or terminal.

---

##  Usage

This project manages a simple `User` entity with fields such as `id`, `name`, and `email`. All CRUD operations are implemented in a `UserDAO` class.

---

##  Example CRUD Operations

```java
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

```



