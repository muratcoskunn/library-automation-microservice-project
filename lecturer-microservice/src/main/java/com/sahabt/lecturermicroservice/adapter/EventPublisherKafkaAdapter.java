package com.sahabt.lecturermicroservice.adapter;

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
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    @Value("${lecturer.event.topic}")
    private String lecturerEventTopic;

    public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate,
                                      ObjectMapper objectMapper
                                      ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(UserEvent userEvent) {
        String lecturerEventAsJson;
        try {
            lecturerEventAsJson = objectMapper.writeValueAsString(userEvent);

            kafkaTemplate.send(lecturerEventTopic,lecturerEventAsJson);
            System.err.println(lecturerEventAsJson);
        } catch (JsonProcessingException e) {

        }

    }

    @Override
    public void publish(BookEvent bookEvent) {

    }
}
