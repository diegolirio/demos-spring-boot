cd demo-jeager-customer
sudo mvn clean package docker:build
cd ../demo-jeager
sudo mvn clean package docker:build
sudo docker-compose down
sudo docker-compose up -d
