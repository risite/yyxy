package com.risite.qg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.risite.qg.reponsitory")
public class QgApplication {

    public static void main(String[] args) {
        SpringApplication.run(QgApplication.class, args);
    }
}
