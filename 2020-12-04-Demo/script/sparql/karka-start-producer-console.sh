    #!/usr/bin/env bash


source environment.sh
# List existing topics
kafka-console-consumer.sh \
    --topic $TOPIC \
    --from-beginning \
    --bootstrap-server $KAFKA_HOST:9092
