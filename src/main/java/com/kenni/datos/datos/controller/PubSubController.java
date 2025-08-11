package com.kenni.datos.datos.controller;

import com.kenni.datos.datos.model.CreditTransaction;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {
    private final PubSubTemplate pubSubTemplate;
    private final ObjectMapper objectMapper;
    private final String topicName;

    public PubSubController(PubSubTemplate pubSubTemplate, ObjectMapper objectMapper,
                            @Value("${gcp.pubsub.topic}") String topicName) {
        this.pubSubTemplate = pubSubTemplate;
        this.objectMapper = objectMapper;
        this.topicName = topicName;
    }

    @PostMapping("/publish-transaction")
    public ResponseEntity<String> publishTransaction(@RequestBody CreditTransaction transaction) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(transaction);
            pubSubTemplate.publish(topicName, jsonMessage);
            return ResponseEntity.ok("Transaction published successfully to topic: " + topicName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error publishing transaction: " + e.getMessage());
        }
    }
}