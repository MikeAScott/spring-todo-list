# Spring Boot Todo List REST API

This is a simple REST API for a Todo List application. It uses Spring Boot, Spring Data JPA and MariaDB.

## Setup

1. Run the `src/main/resources/template.sql` script in your MariaDB instance to create the database
   and the table for the objects.
2. Update `src/main/resources/application.properties` with your database credentials.

## Run the application

_This project uses JDK 21_

1. Run `mvn spring-boot:run` to start the application
2. Import `collection.json` to Postman and run the requests to test the API
