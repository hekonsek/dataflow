#!/usr/bin/env bash

docker build -t hekonsek/reflow-zookeeper:0.0.0-SNAPSHOT .
docker push hekonsek/reflow-zookeeper:0.0.0-SNAPSHOT