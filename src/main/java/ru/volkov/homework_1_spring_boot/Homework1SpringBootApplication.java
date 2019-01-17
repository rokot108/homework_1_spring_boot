package ru.volkov.homework_1_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import ru.volkov.homework_1_spring_boot.services.UserService;

@RestController
@SpringBootApplication
public class Homework1SpringBootApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {

        init(args);
    }


    public static void init(String[] args) {
        context = SpringApplication.run(Homework1SpringBootApplication.class, args);
        final UserService userService = context.getBean("userServiceImpl", UserService.class);

        userService.initUser("admin", "admin", "admin@yandex.ru");
        userService.initUser("testUser", "test", "test@yandex.ru");
    }


}

