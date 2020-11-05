# Read Me First

Netty started on port(s): 8080
Started DemoBootWebflux11Application in 1.278 seconds (JVM running for 1.563)

### Lazy initialization

```properties
spring.main.lazy-initialization=true
spring.config.location=file://./src/main/resources/application.properties
spring.jmx.enabled=false
```

```sh
java -noverify -XX:TieredStopAtLevel=1 -jar target/demo-boot-webflux-11-0.0.1-SNAPSHOT.jar
```

Netty started on port(s): 8080
Started DemoBootWebflux11Application in 0.819 seconds (JVM running for 1.048)

- Docker Image used `fabric8/java-alpine-openjdk11-jre`