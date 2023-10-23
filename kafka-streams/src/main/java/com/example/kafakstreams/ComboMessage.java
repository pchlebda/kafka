package com.example.kafakstreams;

import java.util.List;

public record ComboMessage(List<String> messages) {
    public void add(String message) {
        this.messages.add(message);
    }

    public void addAll(List<String> messages) {
        this.messages.addAll(messages);
    }
}
