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

![image](https://user-images.githubusercontent.com/3913593/98156304-60180480-1eb6-11eb-90c4-b78c385d0842.png)   

---

## Application Class Data Sharing (AppCDS :: Implemented in the open-jdk-10)

Geração do arquivo `classes.lst` com a lista dos objetos usados no Load da aplicação

```sh
java -XX:+UseAppCDS -XX:DumpLoadedClassList=classes.lst -jar target/demo.jar
```
   
```sh
java -Xshare:dump -XX:+UseAppCDS -XX:SharedClassListFile=classes.lst -XX:SharedArchiveFile=app-cds.jsa --class-path target/demo.jar
```

Running APP

```sh
java -Xshare:on -XX:SharedArchiveFile=app-cds.jsa -jar target/demo.jar
```  
   
Ref.: 

https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html      

https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html#app_class_data_sharing   

https://www.linkedin.com/pulse/java-10-application-class-data-sharing-abhi-kerni/   

   
