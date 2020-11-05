# demo-boot-quarkus project

```sh
mvn io.quarkus:quarkus-maven-plugin:1.9.0.Final:create \
    -DprojectGroupId=br.com.canaryinvest \
    -DprojectArtifactId=demo-boot-quarkus \     
    -DclassName="br.com.canaryinvest.CustomerRest" \
    -Dpath="/customers"   
    -Dextensions="quarkus-resteasy,resteasy-jsonb,quarkus-arc,container-image-docker" 
```    

```sh
mvn clean package \
    -Dquarkus.container-image.build=true \
    -Dquarkus.container-image.group=diegolirio
```

Image Base: 
`registry.access.redhat.com/ubi8/ubi-minimal`
`107MB`


started in `0.537s`. Listening on: http://0.0.0.0:8080