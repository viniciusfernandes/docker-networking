#!/usr/bin/env sh

mvn clean package
docker stop customer-provider
docker rm customer-provider
docker network rm customer
docker network create customer
docker rmi -f viniciussf/customer-provider:latest
docker build . -t viniciussf/customer-provider:latest
docker container run --network customer --name customer-provider -p 8082:8080 -d viniciussf/customer-provider:latest
