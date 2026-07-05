# Spring Boot SSRF Demo 🔒

This project demonstrates **Server-Side Request Forgery (SSRF) protection** in a Spring Boot application using `InetAddressFilter` and custom exception handling.

## ❓ What is SSRF?

**Server-Side Request Forgery (SSRF)** is a web security vulnerability that allows an attacker to make the server send HTTP requests to unintended locations.
- Attackers trick the server into fetching internal resources (e.g., `http://localhost/internal/secrets`) or cloud metadata endpoints.
- This can expose sensitive data such as credentials, configuration files, or internal services.
- SSRF is especially dangerous because the server often has access to internal networks that are not publicly exposed.

👉 Example: If a web app lets users preview external URLs, an attacker might supply `http://127.0.0.1:8080/internal/secrets` instead of a public site, attempting to steal internal secrets.

This project shows how to **block such requests** using Spring Boot’s `InetAddressFilter`.

## 📂 Project Structure

- **HttpClientConfig**
  Configures `InetAddressFilter` to block internal/external addresses.

- **InternalSecretController**
  Exposes a mock internal endpoint `/internal/secrets` with sensitive data (for demo purposes).

- **UrlPreviewController**
  Provides `/api/preview` endpoint to fetch and preview external URLs safely.

- **SsrfExceptionHandler**
  Handles `FilteredHostException` and returns a structured error response.

- **UrlPreview**
  Record class to represent URL preview details.

- **SpringBootSsrfApplication**
  Main entry point of the application.

## 🚀 Features

- SSRF Protection using `InetAddressFilter`
- Custom Error Handling with `ProblemDetail`
- Safe URL Preview endpoint that restricts access to internal hosts
- Demo Secrets Endpoint to simulate sensitive internal data

## 🔧 Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/preview?url={url}` | GET | Fetches and previews external URL safely |
| `/internal/secrets` | GET | Returns mock secrets (blocked from external access) |

## ⚠️ Security Notes

- The `/internal/secrets` endpoint is intentionally insecure to demonstrate SSRF risks.
- Requests to internal addresses (e.g., `localhost`, `127.0.0.1`) are blocked by `InetAddressFilter`.
- Any attempt to bypass will trigger a **FilteredHostException** with a **403 Forbidden** response.

## ▶️ Running the Application

```bash
# Clone the repository
git clone https://github.com/your-repo/springboot-ssrf-demo.git
cd springboot-ssrf-demo

# Run the application
./mvnw spring-boot:run
