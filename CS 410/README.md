# CS 410: Software Reverse Engineering

## Course Overview
CS 410 focuses on analyzing compiled software systems to understand how they function without having access to the original source code. The course teaches how to take compiled binary applications, disassemble them into assembly language, and translate those low-level instructions back into higher-order programming languages like C++. Key concepts include recovering legacy software documentation, identifying architectural flaws, and auditing applications for security vulnerabilities.

## Project 2 Overview
For Project Two, the objective was to audit and refactor a legacy C++ desktop application for SNHU Investments to prepare it for a secure cloud migration. The project involved analyzing the source code to identify critical software defects, documenting the risks in a security report, and refactoring the code to patch severe vulnerabilities. 

The remediation work focused on fixing the following issues:
* **Hard-Coded Credentials:** Removing plaintext password verifications that expose the system to unauthorized access.
* **Weak Access Controls:** Fixing logic flaws that displayed sensitive client portfolio data before authentication was completed.
* **Uninitialized Variables:** Correcting unassigned data buffers and pointers to prevent memory leaks and erratic system behavior.
* **Missing Input Validation:** Adding input bounds-checking to prevent unexpected user entries from crashing the application.
