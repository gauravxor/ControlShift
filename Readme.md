# ControlShift backend design

ControlShift backend, implemented using Spring Boot, following a microservice architecture.

## Services

| Service Name        | Description             | Build Status                                                                                        |
| ------------------- | ----------------------- | --------------------------------------------------------------------------------------------------- |
| **OdinService**     | Authentication service  | ![Build Status](https://github.com/gauravxor/OdinService/actions/workflows/build.yml/badge.svg)     |
| **NucleusService**  | User management service | ![Build Status](https://github.com/gauravxor/NucleusService/actions/workflows/build.yml/badge.svg)  |
| **CrownService**    | Leaderboard service     | ![Build Status](https://github.com/gauravxor/CrownService/actions/workflows/build.yml/badge.svg)    |
| **GalactusService** | API Gateway             | ![Build Status](https://github.com/gauravxor/GalactusService/actions/workflows/build.yml/badge.svg) |

## Architecture

- **OdinService** handles authentication and authorization.
- **NucleusService** manages user-related operations.
- **CrownService** maintains the leaderboard logic.
- **GalactusService** serves as the API gateway.

## Getting Started

Each service is a standalone Spring Boot application. You can run them individually or all together using Docker Compose (coming soon).

## Prerequisites

- Java 17+
- Maven 3.8+
- Docker & Docker Compose
