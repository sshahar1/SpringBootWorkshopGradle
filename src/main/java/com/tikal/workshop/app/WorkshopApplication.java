package com.tikal.workshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan({"com.tikal.workshop.controller", "com.tikal.workshop.service",
"com.tikal.workshop.listener"})
@EnableAsync
@EntityScan({"com.tikal.workshop.entity"})
@EnableJpaRepositories({"com.tikal.workshop.repository"})
@EnableKafka
public class WorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

}
