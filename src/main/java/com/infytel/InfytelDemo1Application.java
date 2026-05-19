package com.infytel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class InfytelDemo1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InfytelDemo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hey its a practice demo project in which I have used Spring Data JPA.");
    }
}
