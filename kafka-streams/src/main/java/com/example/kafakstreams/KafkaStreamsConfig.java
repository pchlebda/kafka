package com.example.kafakstreams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamsConfig {

    @Autowired
    public void buildPipeline(StreamsBuilder streamsBuilder, @Value("${main.topic.consumer}") String inputTopic,
            @Value("${main.topic.consumer}") String outputTopic) {
        Serde<String> stringSerde = Serdes.String();
        streamsBuilder
                .stream(inputTopic, Consumed.with(stringSerde, stringSerde))
                .mapValues(m -> m.toUpperCase())
                .to(outputTopic);
    }
}
