# cnj-logging-backend-spring

Cloud native Spring Boot backend with support of cluster logging using an EFK stack:

* everything is logged to stdout (no file appenders)
* uses JSON logging format

## Enable JSON logging in Spring Boot

In order to switch Spring Boot to JSON logging output format, you will have to proceed through the following steps:

### Add a dependency to the Logstash Logback Encoder

Add a dependency to the Logstash Logback Encoder to your POM:

```xml
<dependency>
    <groupId>net.logstash.logback</groupId>
    <artifactId>logstash-logback-encoder</artifactId>
    <version>${logstash.logback.encoder.version}</version>
</dependency>
```

### Add a Logback configuration file to your application

Add a Logback configuration file name `logback-spring.xml` to resource folder `/src/main/resources`.

A sample configuration file can be found [here](src/main/resources/logback-spring.xml).

The special JSON encoder will be activated when Spring profile `cloud` is activated as well.

## Temporarily switching off JSON logging

If you don't want to use the JSON logging format you simply choose any other Spring profile except profile `cloud`.

> Spring profiles are activated by adding an envvar `SPRING_PROFILES_ACTIVE` with a comma-separated list of profiles name that you wish to activate to your container configuration.
>

## Build this application 

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing a Quarkus application.

## Exposed REST endpoints

Simply call the OpenAPI REST endpoint at `/openapi` to get an OpenAPI compliant API specification.

## Exposed environment variables

| Name | Required | Description |
| --- | --- | --- |
| SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI | x | URL of provider endpoint that returns the Json Web Key Set needed to verify the JWT signature |
| SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI | x | URI of the JWT issuer |
| CLOUDTRAIN_SERVICES_DOWNSTREAM_URL | x | Base URL of downstream service |
| POSTGRES_DB_USER | x | PostgreSQL database user | 
| POSTGRES_DB_PASSWORD | x | PostgreSQL database user |
| POSTGRES_DB_NAME | x | PostgreSQL database name |
| POSTGRES_DB_HOST | x | PostgreSQL hostname |
| POSTGRES_DB_PORT | x | PostgreSQL port number |


## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 1.0.0 | first release |
