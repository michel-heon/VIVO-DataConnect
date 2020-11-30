#!/bin/bash
KAFKA_HOST=ec2-52-60-79-186.ca-central-1.compute.amazonaws.com
KAFKA_HOME=/opt/kafka
PATH=$PATH:$KAFKA_HOME/bin
TOPIC=vivo-dataconnect

echo KAFKA_HOST = $KAFKA_HOST
echo TOPIC      = $TOPIC
echo
