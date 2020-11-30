#!/usr/bin/env bash


source environnement.sh
# List existing topics
kafka-topics.sh --list \
    --zookeeper $KAFKA_HOST:2181
