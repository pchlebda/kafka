package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate,
                                               @Value("${main.topic}") String mainTopic) {

        Random random = new Random();


        return args -> {
            IntStream.range(0, 100).forEach(i -> {
                kafkaTemplate.send(mainTopic, "" + (char) (random.nextInt(10) + 97), new Message("Message " + i));
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                kafkaTemplate.flush();
            });
        };
    }
}
