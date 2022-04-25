package com.sahabt.bookmicroservice.adapter;

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
    @Value("${book.event.topic}")
    private String bookEventTopic;

    public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate,
                                      ObjectMapper objectMapper
                                      ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(UserEvent userEvent) {

    }

    @Override
    public void publish(BookEvent bookEvent) {
        String bookEventAsJson;
        try {
            bookEventAsJson = objectMapper.writeValueAsString(bookEvent);

            kafkaTemplate.send(bookEventTopic,bookEventAsJson);
            System.err.println(bookEventAsJson);
        } catch (JsonProcessingException e) {

        }

    }
}
