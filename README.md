# OAuth2Learn

Simple Spring Boot 3.4.5 application demonstrating OAuth2 login with Google.

---

## Tech Stack

```
- Java 17
- Spring Boot 3.4.5
- Spring OAuth2 Client
- Maven
```

---

## Project Structure

```
src/
 ├── main/
 │    ├── java/
 │    │    └── com/estherbaby/oauth2learn/
 │    │         ├── OAuth2LearnApplication.java
 │    │         ├── controller/
 │    │         │    └── HomeController.java
 │    └── resources/
 │         └── application.properties
```

---

## Setup Instructions

### 1. Prerequisites

```
- Java 17+
- Maven 3.8+
- Google OAuth2 Credentials:
    * Create a project in https://console.cloud.google.com
    * Create OAuth Client ID (Web)
    * Add redirect URI:
      http://localhost:8080/login/oauth2/code/google
```

---

### 2. Clone the Repository

```bash
git clone https://github.com/yourusername/oauth2-learn.git
cd oauth2-learn
```

---

### 3. Configure `application.properties`

```properties
server.port=8080

spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=openid,profile,email
spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.google.client-name=Google
```

> 🔐 Replace YOUR_GOOGLE_CLIENT_ID and YOUR_GOOGLE_CLIENT_SECRET with your actual Google credentials.

---

### 4. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

Open: [http://localhost:8080](http://localhost:8080)

---

## Endpoints

```
+------------+------------+-----------------------------------------+
|   URL      |  Access    |               Description               |
+------------+------------+-----------------------------------------+
| /          | Secured    | Displays Google user's name             |
| /secured   | Secured    | Displays a secured page message         |
+------------+------------+-----------------------------------------+
```

---

## How It Works

```
- You visit `/` → redirected to Google Login.
- After login → shows "Hello, {your_name}".
- `/secured` → available only if authenticated.
```

---

## Notes

```
- No database integration — just OAuth2 login.
- Extendable to use role-based security and persistence.
- Great for learning Spring Security with OAuth2.
```

---

## Author

```
Esther Baby
GitHub: https://github.com/yourusername
```

---

## Google User Attributes

```
principal.getAttribute("name")
principal.getAttribute("email")
principal.getAttribute("picture")
principal.getAttribute("sub") // Google user ID
```

---

## Future Enhancements

```
- Add multiple OAuth2 providers (e.g., GitHub, Facebook)
- Save user info to a database
- Add roles and authorities
- Integrate JWT for stateless APIs
- Custom login success handler
```

---

## Example Flow

```
Step 1: Access http://localhost:8080
Step 2: Redirects to Google login
Step 3: Login → Redirect back with user info
Step 4: Displays greeting with your Google name
Step 5: Visit /secured → Allowed only if logged in
```

---
