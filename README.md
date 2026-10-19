# Student Management System

Yeh ek simple **console-based Student Management System** hai jo Java aur MySQL ka use karta hai. Is application se aap students ka data add, update, delete aur view kar sakte hain.

## Features

- Naya student add karna
- Student ka naam, course aur marks update karna
- Student ko ID ke through delete karna
- Sabhi students ka record dekhna
- MySQL database me data permanently save karna

## Project Structure

```text
Student_Magment_System-main/
├── StudentApp.java                 # Main application
├── TestDB.java                     # Database connection test
├── lib/
│   └── mysql-connector-j-8.4.0.jar # MySQL JDBC driver
└── README.md
```

## Requirements

1. Java JDK installed ho. Check karne ke liye:

   ```bash
   java -version
   javac -version
   ```

2. MySQL Server installed aur running ho.
3. MySQL Workbench optional hai. Iska use database aur table banane ke liye kar sakte hain.
4. Project ke `lib` folder me diya gaya MySQL Connector/J JAR file available ho.

## Database Setup

MySQL Workbench ya MySQL command line me yeh SQL commands run karein:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
	id INT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	course VARCHAR(100) NOT NULL,
	marks DOUBLE NOT NULL
);
```

Application abhi in MySQL credentials ka use karti hai:

```text
Username: root
Password: root@123
Database: studentdb
```

Agar aapke MySQL ka username ya password alag hai, to `StudentApp.java` aur `TestDB.java` me connection details update karein.

## Compile and Run on Windows

Project folder me terminal/Command Prompt open karke commands run karein:

```bat
javac -cp ".;lib\mysql-connector-j-8.4.0.jar" StudentApp.java TestDB.java
```

Pehle database connection test karein:

```bat
java -cp ".;lib\mysql-connector-j-8.4.0.jar" TestDB
```

Connection sahi hone par output aayega:

```text
Connected Successfully!
```

Ab main application start karein:

```bat
java -cp ".;lib\mysql-connector-j-8.4.0.jar" StudentApp
```

## Menu ka Use

Application start hone par menu dikhega:

```text
1. Add Student
2. Update Student
3. Delete Student
4. View All Students
5. Exit
```

- **Add Student:** ID, name, course aur marks enter karein.
- **Update Student:** jis student ki details badalni hain uski ID enter karein, phir nayi details dein.
- **Delete Student:** student ki ID enter karein.
- **View All Students:** database me saved sabhi records display honge.
- **Exit:** application band ho jayegi.

## Common Problems

### `DB Connection Failed` ya connection error

- Check karein ki MySQL Server running hai.
- `studentdb` database bana hua hai.
- `StudentApp.java` me username aur password sahi hain.
- Compile/run command me MySQL Connector JAR ka path sahi hai.

### `Table 'studentdb.students' doesn't exist`

Database setup section wala `CREATE TABLE` command run karein.

### `Duplicate entry` error

Har student ke liye unique `id` use karein.

## Important Note

Production project me database password source code me directly nahi rakhna chahiye. Is demo project me learning purpose ke liye credentials code me diye gaye hain.
