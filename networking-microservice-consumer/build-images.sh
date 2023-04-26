#!/usr/bin/env sh

mvn clean package
docker stop customer-consumer
docker rm customer-consumer
docker rmi -f viniciussf/customer-consumer:latest
docker build . -t viniciussf/customer-consumer:latest
docker container run --network customer --name customer-consumer -p 8083:8080 -d viniciussf/customer-consumer:latest
