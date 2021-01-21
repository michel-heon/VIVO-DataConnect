#!/bin/bash 


source environnement.sh
# List existing topics
kafka-topics.sh --create \
  --bootstrap-server $KAFKA_HOST:9092 \
  --replication-factor 1 --partitions 13 \
  --topic $TOPIC
