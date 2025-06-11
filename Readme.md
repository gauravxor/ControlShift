# ControlShift Backend Design

ControlShift backend, implemented using Spring Boot, following a microservice architecture.

## Services

| Service Name        | Description             | Build Status                                                                                        |
| ------------------- | ----------------------- | --------------------------------------------------------------------------------------------------- |
| **OdinService**     | Authentication service  | ![Build Status](https://github.com/gauravxor/OdinService/actions/workflows/build.yml/badge.svg)     |
| **NucleusService**  | User management service | ![Build Status](https://github.com/gauravxor/NucleusService/actions/workflows/build.yml/badge.svg)  |
| **CrownService**    | Leaderboard service     | ![Build Status](https://github.com/gauravxor/CrownService/actions/workflows/build.yml/badge.svg)    |
| **GalactusService** | API Gateway             | ![Build Status](https://github.com/gauravxor/GalactusService/actions/workflows/build.yml/badge.svg) |

## Architecture

- **OdinService** handles authentication, authorization, and onboarding.
- **NucleusService** manages user-related operations.
- **CrownService** maintains the leaderboard logic.
- **GalactusService** serves as the API gateway.

## Tech Stack

- Java 21 (Amazon Corretto 21)
- Maven 3.9.9
- Spring Boot 3.4.5 (per service)
- Docker

## Getting Started

Each service is a standalone Spring Boot application and can be run independently.
