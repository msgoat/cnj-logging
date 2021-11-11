# cnj-logging

Showcase demonstrating cloud native logging in a Kubernetes cluster using a system tool stack based on
Elasticsearch, FluentBit and Kibana.

The actual integration of cluster logging is demonstrated with four different Java backend technologies:

* Eclipse MicroProfile (see: [cnj-logging-backend-micro](cnj-logging-backend-micro/README.md))
* Spring Boot + Spring Data (see: [cnj-logging-backend-spring](cnj-logging-backend-spring/README.md))
* Quarkus (see: [cnj-logging-backend-quarkus](cnj-logging-backend-quarkus/README.md))

All showcases use a common resources container project, which deploys all attached resources to Kubernetes (see: [cnj-logging-resources](cnj-logging-resources/README.md)])

In this showcase, [SL4J](http://www.slf4j.org/) is used as the common logging framework. 

## Status
![Build status](https://drone.cloudtrain.aws.msgoat.eu/api/badges/msgoat/cnj-logging/status.svg)

## Release information

Check [changelog](changelog.md) for latest version and release information.

## Build this showcase 

### Prerequisites

In order to run the build, you have to install the following tools locally:
* Docker
* Docker Compose 
* Maven
* Java JDK 11   

### Run Maven

You can build all showcase applications by running Maven:
```
mvn clean install -P pre-commit-stage
```

The Maven build will create Docker images for all showcase applications and run system tests on them.