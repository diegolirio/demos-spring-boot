# Read Me First

Geração do arquivo `classes.lst` com a lista dos objetos usados no Load da aplicação

```sh
java -XX:+UseAppCDS -XX:DumpLoadedClassList=classes.lst -jar target/demo.jar
```

Gerar o arquivo app-cds.jsa

```sh
java -Xshare:dump -XX:+UseAppCDS -XX:SharedClassListFile=classes.lst -XX:SharedArchiveFile=app-cds.jsa --class-path target/demo.jar
```

Running APP

```sh
java -Xshare:on -XX:SharedArchiveFile=app-cds.jsa -jar target/demo.jar
```