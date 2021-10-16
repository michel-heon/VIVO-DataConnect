#!/usr/bin/env bash

cd /opt

# List existing topics
kafka/bin/kafka-topics.sh --list \
    --zookeeper localhost:2181
