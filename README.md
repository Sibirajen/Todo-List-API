# Todo List API

A Spring Boot RESTful API for managing user tasks with authentication, role-based access, exception handling, pagination, and DTO-layer separation. Built with clean architecture and layered design principles.

---

## Features

- **JWT Authentication** (Login & Register)
- **Role-based Authorization**
- **CRUD Operations** for Tasks
- **Pagination** for task listing
- DTOs, Mappers & Global Exception Handling
- Spring Security Integration
- Global CORS & Security Configuration

---

## Project Structure

```
com.sibirajen.Todo.List.API
├── configuration        # Application configs (Security, Env)
├── controller           # REST controllers
├── dto                  # Request and Response models
├── enums                # Enum types (e.g. Role)
├── exception            # Custom exceptions and handlers
├── mapper               # Entity-DTO mappers
├── model                # JPA entities
├── repo                 # Spring Data JPA repositories
├── security             # JWT filter & service
├── service              # Business logic layer
└── TodoListApiApplication.java # Main Spring Boot app
```

---

## API Endpoints

### Authentication

| Method | Endpoint         | Description      |
|--------|------------------|------------------|
| POST   | `/auth/register` | Register a user  |
| POST   | `/auth/login`    | Login with JWT   |

### Tasks

| Method | Endpoint             | Description            | Auth Required |
|--------|----------------------|------------------------|---------------|
| GET    | `/ap1/v1/todos`      | List tasks (paginated) | ✅             |
| POST   | `/ap1/v1/todos`      | Create new task        | ✅             |
| PUT    | `/ap1/v1/todos/{id}` | Update task            | ✅             |
| DELETE | `/ap1/v1/todos/{id}` | Delete task            | ✅             |

---

Project URL: [Todo List API](https://roadmap.sh/projects/todo-list-api)
