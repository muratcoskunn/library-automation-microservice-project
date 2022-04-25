package com.sahabt.bookmicroservice.configuration;

import application.BookApplication;
import application.business.StandartBookApplication;
import infra.EventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.BookRepository;

@Configuration
public class BookAppConfig {
    @Bean
    BookApplication createBookApp(BookRepository bookRepository, EventPublisher eventPublisher){
        return new StandartBookApplication(bookRepository,eventPublisher);
    }
}
