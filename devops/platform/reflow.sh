#!/usr/bin/env bash

if [[ $1 == 'start' ]]; then
    echo Starting reflow...
    docker run --name=zookeeper -d --net=host hekonsek/reflow-zookeeper:0.0.0-SNAPSHOT
    docker run --name=kafka -d --net=host hekonsek/reflow-kafka:0.0.0-SNAPSHOT
elif [[ $1 == 'stop' ]]; then
    echo Stoping reflow...
    docker stop zookeeper
    docker stop kafka
elif [[ $1 == 'reset' ]]; then
    echo Resetting reflow...
    docker stop zookeeper
    docker rm zookeeper
    docker stop kafka
    docker rm kafka
fi