# Kafka Project example
This project is a simple example of how to use Kafka with Java & Spring Boot.

## Requirements
* Java 17
* Maven 3.8.3

## How to run
1. `mvn clean package`
2. `docker-compose up -d`
3. `java -jar kafka-producer/target/kafka-producer-0.0.1-SNAPSHOT.jar`
4. `java -jar kafka-consumer/target/kafka-consumer-0.0.1-SNAPSHOT.jar`
 
## How to see messages
`http://localhost:9000`