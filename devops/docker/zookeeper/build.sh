#!/usr/bin/env bash

docker build -t hekonsek/reflow-kafka:0.0.0-SNAPSHOT .
docker push hekonsek/reflow-kafka:0.0.0-SNAPSHOT