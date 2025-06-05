package com.example.NotificationDispatcher.service;

import com.example.NotificationDispatcher.component.DeserializedMessage;
import com.example.NotificationDispatcher.dto.RequestContactTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerContact {
    // This service listens to the Kafka topic "Contact_Topic" and processes incoming contact messages.

    private DeserializedMessage deserializedMessage;
    private static final Logger logger = LoggerFactory.getLogger(ListenerContact.class);

    public ListenerContact(DeserializedMessage deserializedMessage) {
        this.deserializedMessage = deserializedMessage;
    }

    @KafkaListener(topics = "Contact_Topic", groupId = "Consumer_PagFlow_Group")
    public void listenTopic(String message) {

        if (message == null || message.isEmpty()) {
            logger.warn("Empty message received. Ignoring.");
            return;
        }

        RequestContactTopic requestContactTopic = deserializedMessage.deserializeRequestTopic(message);




    }
}
