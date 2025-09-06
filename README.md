# 📚 Library Management System (Java + MySQL)

A simple console-based Library System built using **Java JDBC** and **MySQL**.  
It allows users to manage books with basic CRUD operations.

---

## 🚀 Features
- Add new books to the database
- View all books
- Update book details
- Delete books
- MySQL integration with JDBC

---

## ⚙️ Tech Stack
- **Java (JDBC)**
- **MySQL Database**

---

## ▶️ How to Run
1. Create a MySQL database named `librarydb` with a table `books`:

```sql
CREATE DATABASE librarydb;
USE librarydb;
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  year INT
);
```

---

## ⚙️Update database credentials in the code:
```bash
private static final String URL = "jdbc:mysql://localhost:3306/librarydb";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

---

## ▶️ Compile and run the project:
```bash
javac LibrarySystem.java

java LibrarySystem
```
---
👩‍💻 Author

- Developed by Divya Rawat
