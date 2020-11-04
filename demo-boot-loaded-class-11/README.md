# Read Me First

Versao 0-0-1-SNAPSHOT:   
   
Output:
`Started DemoBootLoadedClass11Application in 2.678 seconds (JVM running for 3.428)`

---

Versao 0-0-2-SNAPSHOT: Added properties and JVMs env

`application.properties`:   

```properties
spring.main.lazy-initialization=true
spring.config.location=file://./src/main/resources/application.properties
spring.jmx.enabled=false
```

```sh
java -noverify -XX:TieredStopAtLevel=1 -jar target/demo.jar
```

Output:
`Started DemoBootLoadedClass11Application in 1.556 seconds (JVM running for 2.071)`

---

Versao 0-0-3-SNAPSHOT: Added Undertow

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-undertow</artifactId>
</dependency>	
```        

`Started DemoBootLoadedClass11Application in 1.003 seconds (JVM running for 1.307)`
