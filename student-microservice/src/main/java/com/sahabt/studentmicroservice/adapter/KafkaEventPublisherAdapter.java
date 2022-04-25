package com.sahabt.studentmicroservice.adapter;

import application.business.event.BookEvent;
import application.business.event.UserEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.user.User;
import infra.EventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaEventPublisherAdapter implements EventPublisher {
    private KafkaTemplate<String,String> kafkaTemplate;
    private ObjectMapper objectMapper;
    @Value("${student.event.topic}")
    private String studentTopic;

    public KafkaEventPublisherAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(UserEvent userEvent) {
        try {
            var studentEventAsJson = objectMapper.writeValueAsString(userEvent);
            kafkaTemplate.send(studentTopic,studentEventAsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void publish(BookEvent bookEvent) {

    }
}
