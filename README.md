User Management Application
This is a Spring Boot-based User Management application that allows users to register, authenticate, and manage their profiles. 
The application includes features like input validation, security with roles (ADMIN and USER), database connectivity using Spring Data JPA, and global exception handling.

Open Spring Initializr or use IntelliJ’s Spring Boot project creation wizard.

Set the following project details:

Project: Maven
Language: Java
Spring Boot: 3.3.3
Java Version: 22
Dependencies:
Spring Web
Spring Data JPA
H2 Database
Spring Security
Spring Boot DevTools
Validation

application available at http://localhost:8080.

Database Configuration
In-memory H2 Database:

JDBC URL: jdbc:h2:mem:userdb
Username: sa
Password: (blank)
H2 Console: Accessible at http://localhost:8080/h2-console

Testing
Register a User:

Endpoint: POST /api/users/register
Payload: { "username": "testuser", "password": "Test@1234", "email": "testuser@example.com" }
Login:

Endpoint: POST /api/auth/login
Payload: { "username": "testuser", "password": "Test@1234" }
Secured Endpoints:

Get Users (Admin): GET /api/users
Get User by ID: GET /api/users/{id}
