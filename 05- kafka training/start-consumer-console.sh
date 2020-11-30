#!/usr/bin/env bash
cd /opt

kafka/bin/kafka-console-consumer.sh \
    --bootstrap-server localhost:9092 \
    --topic vivo-connect \
    --from-beginning