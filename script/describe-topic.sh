#!/bin/bash 


source environnement.sh
# List existing topics
kafka-topics.sh --describe \
  --bootstrap-server $KAFKA_HOST:9092 
