# Student Management System

A simple, console-based Java application for managing student records. This project is ideal for beginners looking to understand basic Java concepts like Object-Oriented Programming (OOP), ArrayLists, Exception Handling, and console I/O.

## Features

* **Add Student**: Register a new student with details such as Name, Age, Class, Aadhar Number, and Address. Includes basic age validation (e.g., minimum age for 10th class).
* **View Students**: 
    * View a complete list of all registered students.
    * Search for a specific student by their unique ID.
    * Search for a student by their Name.
* **Edit Student**: Update specific details of an existing student using their ID. You can choose to update only certain fields while keeping the rest unchanged.
* **Delete Student**: Remove a student's record entirely from the system using their ID.

## Prerequisites

To run this application, you need to have Java installed on your machine.
* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (version 8 or higher)

## How to Run

1.  Clone this repository or download the source code.
2.  Open a terminal or command prompt and navigate to the directory containing the file.
3.  Compile the Java file:
    ```bash
    javac Addstudent.java
    ```
4.  Run the compiled program:
    ```bash
    java Addstudent
    ```

## Usage

Upon running the program, you will be presented with a main menu:

1.  **Add Student**: Follow the prompts to enter student details. Type `done` when asked for the full name to return to the main menu.
2.  **View Students**: Choose to see all students, search by ID, or search by Name.
3.  **Edit Student**: Enter the ID of the student you wish to modify. Press `Enter` on any field prompt to keep the existing value.
4.  **Delete Student**: Enter the ID of the student to remove them from the system.
5.  **Exit**: Safely terminate the application.

## Structure

* `Student` class: Defines the structure of a student object.
* `Addstudent` class: Contains the main method, menu loop, and logic for all CRUD (Create, Read, Update, Delete) operations.
