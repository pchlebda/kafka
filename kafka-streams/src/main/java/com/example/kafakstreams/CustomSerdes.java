package com.example.kafakstreams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.List;

public class CustomSerdes {

    public static Serde<List<String>> messageList() {
        JsonSerializer<List<String>> serializer = new JsonSerializer<>();
        JsonDeserializer<List<String>> deserializer = new JsonDeserializer<>(List.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }
}
