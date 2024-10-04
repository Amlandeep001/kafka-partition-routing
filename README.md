# kafka-partition-routing
Mastering Message Routing with Specific Partitions for Open Source Kafka

Commands to start Zookeeper and Kafka :
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

Create Topic: .\bin\windows\kafka-topics.bat --bootstrap-server=localhost:9092 --create --topic "topic-name" --partitions=5 --replication-factor=1


