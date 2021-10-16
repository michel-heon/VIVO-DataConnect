#!/usr/bin/env bash

source environment.sh
# List existing topics
if [ -z $1 ]; 
then 
    offset='latest'; 
else 
    offset=$1;
fi
kafka-console-consumer.sh \
    --topic $TOPIC \
    --max-messages 1000 \
    --bootstrap-server $KAFKA_HOST:9092 \
    --partition 0 \
    --offset $offset
