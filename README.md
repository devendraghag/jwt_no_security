### 📄 `README.md`

```markdown
# JWT Demo without Spring Security

## Overview

This is a basic Spring Boot project demonstrating how to implement JSON Web Token (JWT) based authentication manually — without using Spring Security. It includes:
- A simple `/login` endpoint
- JWT token generation
- Token utility methods for encoding and decoding
- A `User` model with mock validation

## Project Structure

```

jwt-no-security/
├── src/
│   └── main/
│       ├── java/com/example/jwtdemo/
│       │   ├── JwtDemoApplication.java
│       │   ├── controller/AuthController.java
│       │   ├── model/User.java
│       │   ├── service/JwtService.java
│       │   └── util/JwtUtil.java
│       └── resources/application.properties
├── pom.xml

````

## How to Run

### 🔧 Prerequisites
- Java 8+
- Maven
- Postman (for API testing)

### ▶️ Steps to Build & Run

1. **Clone the project** or extract the zip:
   ```bash
   cd jwt-no-security
````

2. **Build the project using Maven:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **Access the login endpoint:**

   ```
   POST http://localhost:8080/login
   ```

   Sample JSON body:

   ```json
   {
     "username": "john",
     "password": "1234"
   }
   ```

5. If credentials match (hardcoded inside `JwtService`), it returns:

   ```json
   {
     "token": "eyJhbGciOiJIUzI1NiIsInR..."
   }
   ```

## Postman Setup

1. Set method to `POST` and URL to `http://localhost:8080/login`
2. Under **Headers**:

    * `Content-Type: application/json`
3. Under **Body > raw > JSON**, enter:

   ```json
   {
     "username": "john",
     "password": "1234"
   }
   ```

## Note

* This project does **not** use Spring Security.
* It's intended for educational purposes or quick prototyping.

## License

MIT – feel free to use and modify for learning purposes.

```
