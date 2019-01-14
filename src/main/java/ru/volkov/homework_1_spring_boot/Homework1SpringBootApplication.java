package ru.volkov.homework_1_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Homework1SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework1SpringBootApplication.class, args);
    }

    @RequestMapping("/**")
    public String helloWorld() {
        return "Hello World";
    }

}

