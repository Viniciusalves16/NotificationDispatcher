package com.example.NotificationDispatcher.component;


import com.example.NotificationDispatcher.dto.RequestContactTopic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeserializedMessage {
// This class is responsible for deserializing messages from the Kafka topic into RequestContactTopic DTOs.


    private static final Logger logger = LoggerFactory.getLogger(DeserializedMessage.class);


    public RequestContactTopic deserializeRequestTopic(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RequestContactTopic contactTopic = objectMapper.readValue(message, RequestContactTopic.class);
            logger.info("Deserialized DTO: {}", contactTopic);
            return contactTopic;
        } catch (Exception e) {
            logger.error("Failed to deserialize message: {}", e.getMessage(), e);
        }
        return null;
    }
}