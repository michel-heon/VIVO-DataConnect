    #!/usr/bin/env bash


source environment.sh
# List existing topics
kafka-console-producer.sh \
    --topic $TOPIC \
    --bootstrap-server $KAFKA_HOST:9092
