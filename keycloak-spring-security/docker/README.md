# Kong + Keycloak UP and Running

1. Subir Keycloak e configurar Realm, Client-IDs, Users, Realm Roles
2. Testar Spring Security + Keycloak
3. Configurar Konga com o Kong
4. Mapear rotas do Kong para o Spring-Security-Keycloak
5. Mapear rotas do Kong para o Spring-GraphQL
6. Connectar Kong com o Keycloak (OpenID Connect)

---

## Keycloak - OK

```shell
docker-compose -f docker-compose-keycloack.yml
```

1. Create Realm (corf)
2. Create Client (corf_front)
3. Create Realm Roles (CUSTODY_GET)
4. Create User (ddamacena)

---

## Kong -OK
```shell
docker-compose -f docker-compose-kong.yml
```

1. Open in your browser http://localhost:1337 to access Konga
2. Request GET http://localhost:8001 to see kong running
3. On Konga map kong-gateway to manager it, name is kong and url is http://kong:8001

## Kong + Spring Boot App - OK

```shell
cd ..
./gradlew bootBuildImage
cd ./docker
docker-compose -f docker-compose-kong-spring-boot.yml
```

1. Create a service, protocol, host and path (service should be the same docker-compose => http://springboot:8081/ in this case)
2. Create route => /products/no-security with Split Path = NO
2. Request http://localhost:8000/products/no-security

### Analisar 
> Analisar padrao http://[kong-gateway-host]/service-name/[route-path-application]
> Aplicacao CDB --> http://cdb-position.intranet.pags/positions/{code}
> Kong --> https://investments.api-gateway.intranet.pags/cdb-position/positions/{code}

## Kong + GraphQL - HERE

1. Configurar kong + GraphQL no Konga

## Kong + OIDC

```shell
docker-compose -f docker-compose-kong-oicd.yml
```

## Kong + Keycloak

```shell
docker-compose -f docker-compose-kong-oicd.yml
```

## Keycloak + Oracle

```shell
docker-compose -f docker-compose-keycloak-oracle.yml
```

## Keycloak Building my Docker Image for Production

```shell
docker build -t diegolirio/keycloak:1.0.0 .
```
