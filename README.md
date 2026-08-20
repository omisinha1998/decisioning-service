# Credit/Loan Decisioning Service

Spring Boot backend for real-time credit decisioning.

## Features
- REST API for loan/credit-card applications
- Rule-based decision engine (APPROVED/REJECTED/REFER)
- Bureau API integration with Resilience4j circuit breaker
- JPA/MySQL persistence
- JUnit tests
- Dockerized with GitHub Actions CI

## Tech Stack
Java 17, Spring Boot 3.3.2, MySQL, Resilience4j, Docker

## Run locally
```bash
docker-compose up --build
```

## API
POST /api/v1/applications
```json
{
  "applicantName": "Omi",
  "annualIncome": 1200000,
  "requestedAmount": 300000,
  "productType": "LOAN"
}
```
