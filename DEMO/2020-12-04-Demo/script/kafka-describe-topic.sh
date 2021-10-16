#!/bin/bash 


source environment.sh
# List existing topics
kafka-topics.sh --describe \
  --bootstrap-server $KAFKA_HOST:9092 
