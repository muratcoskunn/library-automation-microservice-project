package com.sahabt.officermicroservice.adapter;

import application.business.event.BookEvent;
import application.business.event.UserEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import infra.EventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherKafkaAdapter implements EventPublisher {
    private KafkaTemplate<String,String> kafkaTemplate;
    @Value("${officer.event.topic}")
    private String officerEventTopic;
    private ObjectMapper objectMapper;


    public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(UserEvent userEvent) {
        try {
            var officerEventAsJson = objectMapper.writeValueAsString(userEvent);
            kafkaTemplate.send(officerEventTopic,officerEventAsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void publish(BookEvent bookEvent) {

    }
}
