# TaskFlow Backend

API REST para gestión de tareas con autenticación JWT desarrollada con Spring Boot.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security + JWT (auth0 java-jwt)
- Spring Data JPA
- H2 Database (base de datos en memoria para desarrollo)
- Maven
- JUnit 5 + Mockito (pruebas unitarias y de integración)

## Características

- Registro y autenticación de usuarios con JWT
- CRUD de tareas (crear, listar)
- Validaciones con Jakarta Validation
- Manejo global de excepciones
- Arquitectura por capas (Controller → Service → Repository)
- Documentación de API con Swagger (OpenAPI)
- Pruebas unitarias e integración

## Endpoints principales

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|----------------|
| POST | `/api/auth/register` | Registrar nuevo usuario | No |
| POST | `/api/auth/login` | Iniciar sesión (retorna token JWT) | No |
| GET | `/api/tasks` | Listar todas las tareas | Sí (Bearer token) |
| POST | `/api/tasks` | Crear una nueva tarea | Sí (Bearer token) |

