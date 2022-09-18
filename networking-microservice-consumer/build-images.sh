#!/usr/bin/env sh

mvn clean package
docker stop microservice-consumer
docker rm microservice-consumer
docker rmi -f viniciussf/microservice-consumer:latest
docker build . -t viniciussf/microservice-consumer:latest