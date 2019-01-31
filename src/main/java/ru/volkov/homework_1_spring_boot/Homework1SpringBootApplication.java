package ru.volkov.homework_1_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import ru.volkov.homework_1_spring_boot.services.ProductService;
import ru.volkov.homework_1_spring_boot.services.UserService;

@RestController
@IntegrationComponentScan
@SpringBootApplication
public class Homework1SpringBootApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {

        init(args);

        final Message<String> message = MessageBuilder
                .withPayload("Test message")
                .setHeader("header1", "value1")
                .build();

        final MessageChannel direct_channel_one = (DirectChannel) context.getBean("direct_channel_one");
        direct_channel_one.send(message);
    }


    public static void init(String[] args) {
        context = SpringApplication.run(Homework1SpringBootApplication.class, args);
        final UserService userService = context.getBean("userServiceImpl", UserService.class);
        final ProductService productService = context.getBean("productServiceImpl", ProductService.class);
        final BCryptPasswordEncoder passwordEncoder = context.getBean("passwordEncoder", BCryptPasswordEncoder.class);

        userService.initUser("admin", passwordEncoder.encode("admin"), "admin@yandex.ru", "ADMIN");
        userService.initUser("user", passwordEncoder.encode("user"), "test@yandex.ru", "USER");
        productService.initProduct(1, "Pivko", "Svetloe");
    }


}

