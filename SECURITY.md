# Security Policy

## Supported Versions

Currently, only the latest version of the Student Management System is supported with security updates.

| Version | Supported          |
| ------- | ------------------ |
| 1.0.x   | :white_check_mark: |
| < 1.0   | :x:                |

## Reporting a Vulnerability

I take the security of this project seriously. If you find a security vulnerability, please do not report it publicly via GitHub issues. Instead, please follow the steps below:

1.  **Contact**: Reach out to the maintainer directly (you can add your email or contact method here).
2.  **Description**: Provide a detailed description of the vulnerability, including steps to reproduce the issue.
3.  **Impact**: Explain the potential impact of the vulnerability.

I will acknowledge your report within 48 hours and provide a timeline for a fix.

## Best Practices for Users

Since this is a console-based application that stores data in memory:

* **In-Memory Storage**: Be aware that student data is stored in an `ArrayList` and is lost when the program terminates. For production use, a persistent database should be implemented.
* **ID as Password**: The current version uses the Student ID as a "password." Note that this is for demonstration purposes only. In a real-world scenario, you should use hashing (like BCrypt) to store passwords.
* **Private Data**: Do not enter real Aadhar numbers or sensitive personal addresses if you are running this in a shared or public environment.
* **Code Access**: Since the code is open-source, anyone with access to the machine can read the source code. Ensure you keep your development environment secure.

## Future Security Improvements
* Implementation of password hashing.
* Input sanitization to prevent potential injection attacks if a database is added.
* Session management for different user roles (Admin vs. Student).
