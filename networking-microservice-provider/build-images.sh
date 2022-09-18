#!/usr/bin/env sh

./gradlew clean build
docker stop microservice-provider
docker rm microservice-provider
docker rmi -f viniciussf/microservice-provider:latest
docker build . -t viniciussf/microservice-provider:latest