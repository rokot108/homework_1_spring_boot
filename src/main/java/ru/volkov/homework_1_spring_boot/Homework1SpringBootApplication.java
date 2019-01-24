package ru.volkov.homework_1_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import ru.volkov.homework_1_spring_boot.services.ProductService;
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
        final ProductService productService = context.getBean("productServiceImpl", ProductService.class);
        final BCryptPasswordEncoder passwordEncoder = context.getBean("passwordEncoder", BCryptPasswordEncoder.class);

        userService.initUser("admin", passwordEncoder.encode("admin"), "admin@yandex.ru", "ADMIN");
        userService.initUser("user", passwordEncoder.encode("user"), "test@yandex.ru", "USER");
        productService.initProduct(1, "Pivko", "Svetloe");
    }


}

