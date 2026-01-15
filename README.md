# Java Backend Interview Assignment

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MSSQL
- Maven

## Database
- Database: TESTDB
- Database: MSSQL (Local)

## APIs
| Method | Endpoint | Description |
|------|---------|------------|
| POST | /api/clients | Create client |
| GET | /api/clients?page=0 | Get clients (Pagination: 10 records/page) |
| PUT | /api/clients/{id} | Update client |
| GET | /api/clients/external | Nested external API call |

## Pagination
- Page size: 10
- Example:
