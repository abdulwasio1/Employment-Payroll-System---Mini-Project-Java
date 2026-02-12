# 🧾 Employment-Payroll-System---Mini-Project-Java
 
A comprehensive Employee Payroll Management System built in Java that demonstrates Object-Oriented Programming concepts. This console-based application allows you to manage both full-time and part-time employees with full CRUD operations.

## 📋 Features
**Add Employees -** Register both Full-Time and Part-Time employees

**Remove Employees -** Delete employees by their unique ID

**Search Employees -** Find and display employee details by ID

**Update Employees -** Modify ID, Name, or Salary details

**View All Employees -** Display complete employee list with formatted output

**Smart ID Validation -** Prevents duplicate employee IDs

**Dynamic Salary Calculation -** Automatic salary computation based on employee type

## 🏗️ Project Structure
Codes.Mini_Project

├── 📄 Control.java         
├── 📄 Employee.java       
├── 📄 full_time.java        
├── 📄 part_time.java       
├── 📄 Main.java           
└── 📄 menu.java

## 🧩 Class Details
### 🔹 Employee (Abstract)
**Attributes:** name, id, type

**Methods:**

**calSalary() -** Abstract method for salary calculation

**toString() -** Formatted employee information display

**Getters & Setters**

### 🔹 full_time (Inherits Employee)**
**Additional Attribute:** monthlySalary

**Method:** calSalary() - Returns fixed monthly salary

### 🔹 part_time (Inherits Employee)
**Additional Attributes:** hours, hourRate

**Method:** calSalary() - Returns hours × hourRate

### 🔹 Control
**Attribute:** ArrayList<Employee> - Employee database

**Methods:**

**addEmp() -** Add new employee

**removeEmp() -** Remove by ID

**displayAll() -** View all records

**check() -** Search employee

**updateId(), updateName(), updateSalarySimple() -** Update operations

**exits() -** ID existence check

**returnObj() -** Get employee object by ID

## 💡 Key Concepts Demonstrated
### ✅ Object-Oriented Programming (OOP)

**Inheritance** (Employee → full_time/part_time)

**Polymorphism** (calSalary() implementation)

**Encapsulation** (private fields with getters/setters)

**Abstraction** (abstract class Employee)

### ✅ Data Structures

ArrayList for dynamic employee storage

### ✅ Exception Handling

Input validation for positive numbers

Duplicate ID prevention

### ✅ User Interface

Clean console-based menu system

Formatted ASCII box displays

## 🔮 Future Enhancements
**File I/O -** Save/load employee data to files

**Database Integration -** MySQL/PostgreSQL connectivity

**GUI Interface -** JavaFX/Swing desktop application

**Payroll Processing -** Generate salary slips

**Department Management -** Categorize employees by departments

**Leave Management -** Track employee leaves

**Export Reports -** PDF/Excel export functionality

**Unit Testing -** JUnit test cases
