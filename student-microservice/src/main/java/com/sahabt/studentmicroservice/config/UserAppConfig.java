package com.sahabt.studentmicroservice.config;
import application.UserApplication;
import application.business.StandartUserApplication;
import infra.EventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.UserCrudRepository;

@Configuration
public class UserAppConfig {
    @Bean
    public UserApplication createUserApplication(UserCrudRepository userRepository, EventPublisher eventPublisher){
        return new StandartUserApplication(userRepository,eventPublisher);
    }
}
