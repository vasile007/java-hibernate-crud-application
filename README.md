## 🛠️ Java Hibernate CRUD Application

This is a simple **CRUD (Create, Read, Update, Delete)** application built with **Java** and **Hibernate ORM**, using **MySQL** as the database. It demonstrates basic operations on a `User` entity using Hibernate for object-relational mapping.

![Java](https://img.shields.io/badge/Java-11+-blue?style=flat&logo=java)
![Hibernate](https://img.shields.io/badge/Hibernate-5.x-blue?style=flat&logo=hibernate)
![License](https://img.shields.io/badge/License-MIT-green.svg)

---
### 📋 Table of Contents

- [📖 About](#about)
- [🧰 Technologies Used](#technologies-used)
- [⚙️ Installation & Setup](#installation--setup)
- [🚀 Usage](#usage)
- [🧪 Example CRUD Operations](#example-crud-operations)
- [🤝 Contributing](#contributing)
- [🛡️ License](#license)

---
## 📖 About

This project demonstrates how to implement basic CRUD operations using Hibernate ORM in Java. It connects to a MySQL database and uses Hibernate to persist and retrieve data using annotated JPA entities.
---
## 🧰 Technologies Used
- Java 11+
- Hibernate ORM (5.x)
- JPA (Java Persistence API)
- MySQL 8+
- Maven

---

### ⚙️ Installation & Setup

### 1. Clone the repository

bash
git clone https://github.com/your-username/hibernate-crud-app.git
cd hibernate-crud-app
---

 ### Configure database connection
Edit the hibernate.cfg.xml file and set your database URL, username, and password:

<property name="connection.url">jdbc:mysql://localhost:3306/your_database</property>
<property name="connection.username">your_username</property>
<property name="connection.password">your_password</property>
---
### Build the project in bash
mvn clean install
--

### Run the application
You can run the main class (e.g. App.java) from your IDE or command line.

###🚀 Usage
This application performs operations on a simple User entity with fields like id, name, and email. It uses a UserDAO class to manage data operations.
--
🧪 Example CRUD Operations

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

----
🤝 Contributing
Contributions are welcome! To contribute:

1. Fork the repository.

2. Create a new branch: git checkout -b feature-name.

3. Make your changes and commit: git commit -m 'Add feature'.

4. Push to the branch: git push origin feature-name.

5. Open a Pull Request.
----

📧 Contact
If you have any questions or suggestions, feel free to open an issue or contact me at bejan.vasi@yahoo.com.com.




