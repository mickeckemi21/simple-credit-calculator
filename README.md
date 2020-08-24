# Simple Credit Calculator

### Getting started
To start the application you can use maven wrapper with spring-boot maven plugin:

```java
./mvnw spring-boot:run
```

Above command will start the embedded Tomcat web server on port <em>8080</em>. To access 
the web service you should use <em>http:\/\/localhost:8080</em>.

The application also ships with <em>Postman</em> collection and tests which can 
be found under <em>src/test/postman</em>. Including the collection into Postman, you can 
run few tests against application's ReST endpoints.

There are also IT tests included inside <em>src/test/java/controller</em> package. To run 
IT tests outside the IDE, you can use the following maven command:

```java
./mvnw clean integration-test
```

Inside the IT test examples can be found which payload is expected and 
what response will be returned.