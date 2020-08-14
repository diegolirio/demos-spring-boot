cd demo-jeager-customer
mvn clean package docker:build
cd ../demo-jeager
mvn clean package docker:build
docker-compose down
docker-compose up -d
