#!/bin/bash 
source environment.sh

kafka-run-class.sh kafka.admin.ConsumerGroupCommand \
    --bootstrap-server $KAFKA_HOST:9092 \
    --all-groups \
    --describe
