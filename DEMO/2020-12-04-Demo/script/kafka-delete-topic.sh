#!/bin/bash 


source environment.sh
# List existing topics
kafka-topics.sh --delete \
  --bootstrap-server $KAFKA_HOST:9092 \
  --topic $TOPIC
  
  #  --replication-factor 1 --partitions 13 \
  
