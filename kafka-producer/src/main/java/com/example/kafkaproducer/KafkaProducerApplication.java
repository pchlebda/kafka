package com.example.kafkaproducer;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(KafkaTemplate<?, Message> kafkaTemplate,
            @Value("${main.topic}") String mainTopic) {
        return args -> {
            IntStream.range(0, 5).forEach(i -> kafkaTemplate.send(mainTopic, new Message("Message " + 1)));
            kafkaTemplate.flush();
        };
    }
}
