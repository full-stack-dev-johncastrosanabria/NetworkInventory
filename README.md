# Network Inventory

Java inventory portfolio repository using **Spring Boot Web**, **Spring Data Neo4j** and **Maven**, as declared in [pom.xml](pom.xml).

## Repository status

The repository contains a Spring Boot project and Maven wrappers. Its public API contracts, feature walkthrough and database setup still need dedicated documentation. This entry point identifies the available stack without claiming an undocumented feature set or deployment status.

## Getting started

1. Review [pom.xml](pom.xml) for the Java, Spring Boot and dependency requirements.
2. Configure a Neo4j instance and the application settings for your local environment.
3. Use the included Maven wrapper to build or run the configured checks:

```bash
./mvnw test
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd` instead of `./mvnw`.

## Next documentation milestones

- Feature overview and example requests/responses.
- Reproducible Neo4j setup and configuration template.
- Architecture decisions and current test results.

See [John Castro Sanabria's profile](https://github.com/full-stack-dev-johncastrosanabria) for the main full-stack and AI projects.
