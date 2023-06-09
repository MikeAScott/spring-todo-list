# Sample To Do List web application using Spring Boot and MariaDB

A simple Todo list application using Spring Boot with the following options:

- Spring JPA and MariaDB for data persistence
- Thymeleaf template for the rendering

To build and run the sample from a fresh clone of this repo:

## Configure MariaDB

1. Create a database in your MariaDB instance.
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for
   your MariaDB instance. The table schema for the Todo objects will be created for you in the database.

## Build and run the sample

_This needs the Java 17 JDK_

1. `mvn clean install`
2. `java -jar target/spring-todo-list.jar`
3. Open a web browser to http://localhost:8080

As you add and update tasks in the app you can verify the changes in the database through the MariaDB console using
simple
statements like
`select * from todo`.
