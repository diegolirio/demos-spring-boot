# Kong + Keycloak UP and Running

## Keycloak - OK

```shell
docker-compose -f docker-compose-keycloack.yml
```

## Kong - HERE <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

```shell
docker-compose -f docker-compose-kong.yml
```

## Kong + Spring Boot App 

```shell
cd ..
./gradlew bootBuildImage
cd ./docker
docker-compose -f docker-compose-kong-spring-boot.yml
```

## Keycloak + Oracle

```shell
docker-compose -f docker-compose-keycloak-oracle.yml
```

## Kong + OIDC

```shell
docker-compose -f docker-compose-kong-oicd.yml
```

## Kong + Keycloak

```shell
docker-compose -f docker-compose-kong-oicd.yml
```

## Keycloak Building my Docker Image for Production

```shell
docker build -t diegolirio/keycloak:1.0.0 .
```