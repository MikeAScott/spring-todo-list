# Sample To Do List web application using Spring Boot and MySQL

A simple Todo list application using Spring Boot with the following options:

- Spring JPA and MySQL for data persistence
- Thymeleaf template for the rendering.

To build and run the sample from a fresh clone of this repo:

## Configure MySQL

1. Create a database in your MySQL instance.
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance. The table schema for the Todo objects will be created for you in the database.


## Build and run the sample

N.B. This needs the Java 11 JDK - It has been tested with the OpenJDK v11.0.6

1. `mvnw package`
3. `java -jar target/TodoDemo-0.0.1-SNAPSHOT.jar`
3. Open a web browser to http://localhost:8080

As you add and update tasks in the app you can verify the changes in the database through the MySQL console using simple statements like 
`select * from todo_item`.

Change to Readme
