# cnj-logging-downstream

Cloud native Java application based on Spring Boot acting as downstream service consumed by the other backends.

## Build this application 

``` 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing a Spring Boot application.

## Exposed REST endpoints


## Exposed environment variables

| Name | Required | Description |
| --- | --- | --- |
| SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_JWK_SET_URI | x | OpenID Connect Provider endpoint to retrieve key set to verify JWT token signatures |
| SPRING_SECURITY_OAUTH2_RESOURCESERVER_JWT_ISSUER_URI | x | Expected JWT Issuer URI |


## Exposed Ports

| Port | Protocol | Description |
| --- | --- | --- |
| 8080 | HTTP | HTTP endpoint of this application | 
 
## Version / Tags

| Tag(s) | Remarks |
| --- | --- |
| latest, 4.0.0 | first release |
