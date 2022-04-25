package com.sahabt.officermicroservice.config;

import application.UserApplication;
import application.business.StandartUserApplication;
import infra.EventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import repository.UserCrudRepository;

@Component
public class UserAppConfig {
    @Bean
    public UserApplication createOfficerApp(UserCrudRepository userRepository, EventPublisher eventPublisher){
        return new StandartUserApplication(userRepository,eventPublisher);
    }
}
