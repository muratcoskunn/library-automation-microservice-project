package com.sahabt.officermicroservice.service.business;

import com.sahabt.officermicroservice.entity.BookEntity;
import com.sahabt.officermicroservice.repository.BookEntityRepo;
import com.sahabt.officermicroservice.service.ConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService implements ConsumerService {
    private BookEntityRepo bookEntityRepo;

    public KafkaConsumerService(BookEntityRepo bookEntityRepo) {
        this.bookEntityRepo = bookEntityRepo;
    }

    @KafkaListener(topics = "lec-topic",groupId = "lecturerAdded")
    @Override
    public void listenMessage(String identity) {
        System.err.println(identity+" consumer");
    }
    @KafkaListener(topics="book-topics",groupId = "bookAdded")
    public void listenBooks(String identity){
        BookEntity bookEntity = new BookEntity(identity);
        bookEntityRepo.save(bookEntity);
    }
}
