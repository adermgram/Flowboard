# FlowBoard

A collaborative project management backend inspired by tools like Trello. FlowBoard allows users to organize workspaces, boards, and tasks while managing access through workspace memberships and roles.

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Current Features

- User registration and login
- Password hashing with BCrypt
- JWT-based authentication
- Workspace creation
- Automatic workspace ownership for creators
- Workspace membership management foundation
- Role-based authorization (`OWNER`, `ADMIN`, `MEMBER`)
- Board creation with workspace access control
- REST API with DTOs and validation

## Architecture

The application follows a layered architecture:

```text
Controller → Service → Repository → Database
```

- **Controllers:** Handle HTTP requests and responses.
- **Services:** Contain business logic and authorization rules.
- **Repositories:** Handle database operations through Spring Data JPA.
- **Entities:** Represent the application's domain model.

## Running Locally

1. Ensure Java 17, Maven, and PostgreSQL are installed.
2. Create a PostgreSQL database named `flowboard`.
3. Configure your database credentials in `application.properties`.
4. Set the `JWT_SECRET` environment variable.
5. Start the application:

```bash
mvn spring-boot:run
```

The API runs on `http://localhost:8080`.

## Project Status

🚧 Under active development.

Planned features include workspace member management, task and column management, real-time collaboration with WebSockets, Redis integration, and event-driven functionality.

---

Built as a hands-on backend engineering project focused on understanding Spring Boot, persistence, security, and real-time systems.