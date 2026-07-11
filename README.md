# Grade Tracker

A Java console application for tracking student grades, upgraded with a real MySQL database using JDBC.

## Features 
- Add new students to a MySQL database
- Add grades per student
- Show all students with basic details
- Print full report with average, highest, and lowest grade
- Delete students and grades
- Interactive menu with switch statement
- Auto-closing database connection with try-with-resources

## Concepts Demonstrated
- JDBC (Java Database Connectivity)
- MySQL database with two tables (students, grades)
- PreparedStatement for safe SQL queries
- ResultSet iteration 
- Try-with-resources for connection management
- Switch statement for menu navigation
- OOP with encapsulation and getters

## Tech Stack
- Java (Apache NetBeans)
- MySQL 8.0
- MySQL Connector/J 9.7.0

## How to Run
- Set up MySQL and create a database called gradetracker
- Create a config.properties file in the project root with:
    db.url=jdbc:mysql://localhost:3306/gradetracker
    db.username=your_mysql_username
    db.password=your_mysql_password
- Create students and grades tables
- Add mysql-connector-j to your project classpath
- Update the url, username and password in GradeTracker.java
- Run GradeTracker.java
