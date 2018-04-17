# demo-fabric8
Spring Boot with Plugin Fabric8 - Run Docker


Run Local Container (http://localhost:3001)
```
sudo ./deploy.sh
```

### Build and Deploy Image In Registry:
- Development   
```
sudo su
mvn clean install -P develop fabric8:build fabric8:push
```
- Homolog
```
sudo su
mvn clean install -P homolog fabric8:build fabric8:push
```
- Production
```
sudo su
mvn clean install -P prod fabric8:build fabric8:push
```
`See`: http://p4go-devops.southindia.cloudapp.azure.com:5000/v2/demo-fabric8/tags/list






Observações:   
- Se seu Registry remoto está sem certificado, você deverá configurar seu docker client, habilitando o modo de insegurança:
`/etc/docker/daemon.json`
```json
{
    "insecure-registries" : [ 
        "p4go-devops.southindia.cloudapp.azure.com:5000"
       ]
}
```
- Se seu Registry remoto está com certificado(HTTPS), você também deverá configurar seu docker client, adicionando o certificado:
`/etc/docker/certs.d/[host]/ca.crt`
```sh
sudo su
cd /etc/docker/certs.d/
mkdir registry.phoenix4go.com
cd registry.phoenix4go.com
cp meu_domain.cert ./ca.crt
```

Restart Docker Service: `/etc/init.d/docker restart`
