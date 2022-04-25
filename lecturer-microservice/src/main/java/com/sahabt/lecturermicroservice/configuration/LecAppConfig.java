package com.sahabt.lecturermicroservice.configuration;

import application.UserApplication;
import application.business.StandartUserApplication;
import infra.EventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.UserCrudRepository;

@Configuration
public class LecAppConfig {
    @Bean
    UserApplication createUserApp(UserCrudRepository userRepository, EventPublisher eventPublisher){
        return new StandartUserApplication(userRepository,eventPublisher);
    }
}
