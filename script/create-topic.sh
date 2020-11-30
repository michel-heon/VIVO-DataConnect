#!/bin/bash 


source environnement.sh
# List existing topics
kafka-topics.sh --create \
  --zookeeper $KAFKA_HOST:2181 \
  --replication-factor 1 --partitions 13 \
  --topic $TOPIC
