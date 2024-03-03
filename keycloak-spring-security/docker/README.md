# Kong + Keycloak UP and Running

1. Subir Keycloak e configurar Realm, Client-IDs, Users, Realm Roles `OK`
2. Testar Spring Security + Keycloak `OK`
3. Configurar Konga com o Kong `OK`
4. Mapear rotas do Kong para o Spring-Security-Keycloak `OK`
5. Mapear rotas do Kong para o Spring-GraphQL `OK`
6. Connectar Kong com o Keycloak (OpenID Connect) `in_progress`

---

## Keycloak - `OK`

```shell
docker-compose -f docker-compose-keycloack-security.yml
```

1. Access [Keycloak](http://localhost:8080)
2. Create Realm (corf)
3. Create Client (corf_front)
4. Create Realm Roles (CUSTODY_GET)
5. Create User (ddamacena)
6. Perform Login on test-keycloak.http
7. Catching and putting token in Authorization-Header in the request the second example in test-keycloak.http.    
8. A error should be presented, you need to add role in the ddamacena's Role Mapping (CUSTODY_GET) and Request again.

---

## Kong - `OK`
```shell
docker-compose -f docker-compose-kong.yml
```

1. Open in your browser http://localhost:1337 to access Konga
2. Request GET http://localhost:8001 to see kong running
3. On Konga map kong-gateway to manager it, name is kong and url is http://kong:8001

## Kong + Spring Boot App - `OK`

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

## Kong + GraphQL - `OK`

1. Configurar kong + GraphQL no Konga

## Kong + OIDC - `HERE`  

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

## Keycloak Building my Docker Image for Production (Kubernetes)

```shell
docker build -t diegolirio/keycloak:1.0.0 .
```

## Kong for Production (Kubernetes)

```shell
docker build -t diegolirio/keycloak:1.0.0 .
```