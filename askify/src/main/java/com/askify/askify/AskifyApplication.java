package com.askify.askify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.askify")
@ComponentScan(basePackages = "com.askify")
@EnableJpaRepositories(basePackages = "com.askify")
public class AskifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AskifyApplication.class, args);
    }

}
