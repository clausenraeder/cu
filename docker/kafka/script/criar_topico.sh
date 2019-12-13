#!/bin/bash
if [/opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --list --zookeeper 0.0.0.0:2181 | grep topicpag]; then 
    ehco "Topico Criado"; 
else 
    /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --create --zookeeper 0.0.0.0:2181 --replication-factor 1 --partitions 1 --topic topicpag;
fi