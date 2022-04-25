package com.sahabt.borrowmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BorrowMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowMicroserviceApplication.class, args);
    }

}
