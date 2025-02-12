# Student Management System Using Java

## Overview
The **Student Management System** is a simple Java-based application that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records. The system uses MySQL as the backend database for storing student information.

## Features
- Add a new student
- View all students
- Update student details
- Delete a student
- User-friendly command-line interface

## Technologies Used
- **Java** (Core Java, JDBC)
- **MySQL** (Database Management)

## Project Structure
```
StudentManagementSystem/
│-- src/
│   │-- Student.java
│   │-- Database.java
│   │-- Operation.java
│   │-- StudentManagement.java
│-- README.md
│-- pom.xml (if using Maven)
```

## Setup and Installation

### Prerequisites
- Install **Java JDK** (version 8 or later)
- Install **MySQL Server**
- Configure **JDBC Driver**

### Database Configuration
1. Create a database in MySQL:
   ```sql
   CREATE DATABASE studentdb;
   USE studentdb;
   ```
2. Create a table for storing student details:
   ```sql
   CREATE TABLE students (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       age INT NOT NULL,
       grade VARCHAR(10) NOT NULL
   );
   ```
3. Update the database credentials in `Database.java`:
   ```java
   private static final String URL = "jdbc:mysql://127.0.0.1:3306/studentdb";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

### Running the Application
1. Compile the Java files:
   ```sh
   javac -d . src/*.java
   ```
2. Run the application:
   ```sh
   java StudentManagement
   ```

## Usage
- Follow the on-screen instructions to add, view, update, or delete students.
- Enter the appropriate details when prompted.

## Future Enhancements
- Implement GUI using Java Swing or JavaFX
- Add authentication for users
- Improve database performance with indexing

## License
This project is open-source and available under the MIT License.

