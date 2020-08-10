# cnj-logging-backend-quarkus

Cloud native Quarkus backend with support of cluster logging using an EFK stack:

* everything is logged to stdout (no file appenders)
* uses JSON logging format

## Enable JSON logging in Quarkus

In order to switch Quarkus to JSON logging output format, you will have to proceed through the following steps:

### Add a dependency to the JSON logging extension

Add a dependency to the JSON logging extension to your POM:

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-logging-json</artifactId>
</dependency>
```

## Temporarily switching off JSON logging

JSON formatted log files are hard to read for humans. Fortunately, you can switch off JSON logging by adding
a profiled configuration property to your application.properties file:

```properties
%dev.quarkus.log.console.json=false
```

Now if you activate profile __dev__, JSON logging will be switched off, although the JSON logging extension has been added to your application.

> Quarkus profiles are activated by adding an envvar `QUARKUS_PROFILE` with the name of the profile to activate to your Docker container configuration.
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
| MP_JWT_VERIFY_PUBLICKEY_LOCATION | x | REST endpoint of an OpenID Connect authentication provider returning the JWT key set |
| MP_JWT_VERIFY_ISSUER | x | ID of the JWT's issuer |
| CLOUDTRAIN_SERVICES_GRANTEDPERMISSIONS_MP_REST_URL | x | Base URL of downstream service |
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
