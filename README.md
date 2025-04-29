# OAuth2 Google Login Project

This is a Spring Boot project implementing OAuth2 login using Google as an authentication provider. It demonstrates how to configure Spring Security to use OAuth2, handle login, logout, and display user information after authentication.

## Features
- OAuth2 login with Google.
- Logout functionality with a redirection to a custom page (`/whoami`).
- Displays a personalized greeting on the home page after successful login.
- Simple controller to display "Hello, Guest!" if the user is not authenticated.
- Handles logout and clears the session properly.

## Prerequisites
- Java 17 or later.
- Maven 3.8+.
- A Google OAuth2 client ID and secret.

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-repo/oauth2-google-login.git
cd oauth2-google-login
```

### 2. Update `application.properties`

In the `src/main/resources/application.properties` file, configure your Google OAuth2 credentials as follows:

```properties
server.port=8080

spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=openid,profile,email
spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.google.client-name=Google
```

> 🔐 Replace YOUR_GOOGLE_CLIENT_ID and YOUR_GOOGLE_CLIENT_SECRET with your actual Google credentials.

Make sure to replace `YOUR_GOOGLE_CLIENT_ID` and `YOUR_GOOGLE_CLIENT_SECRET` with your actual Google credentials.

### 3. Run the application

```bash
mvn spring-boot:run
```

Once the application is running, you can visit `http://localhost:8080` to see the login page.

### 4. How the App Works

- **Home Page (`/`)**: Displays a greeting message based on the user’s login status. If logged in, it shows "Hello, [username]"; otherwise, it shows "Hello, Guest!".
- **Secured Page (`/secured`)**: This is a secured page, visible only after authentication. It confirms that the user is authenticated.
- **Logout Page (`/logout-link`)**: Displays a logout link. Clicking on this link logs the user out and redirects them to `/whoami`.
- **Whoami Page (`/whoami`)**: After logout, the `/whoami` page will show "You are logged out".

### 5. Logout Functionality

After clicking the "Logout" button:
- The session is invalidated.
- The user is redirected to the `/whoami` page.
- The `/whoami` page displays "You are logged out.".

### 6. Notes
- The user is redirected to `/whoami` after logging out, and the page will display their logout status.
- This app uses Spring Security's default OAuth2 login flow, with no custom UI for login/logout, and it handles sessions, cookies, and security configurations automatically.

## Troubleshooting

- If you encounter any issues during login or logout, check your Google API credentials (client ID and secret) and ensure the correct redirect URI is configured.
- If you see a `404 Not Found` for favicon.ico, it's due to missing favicon assets. You can safely ignore this in development.

---