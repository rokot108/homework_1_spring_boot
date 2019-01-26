package ru.volkov.homework_1_spring_boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.volkov.homework_1_spring_boot.model.Product;
import ru.volkov.homework_1_spring_boot.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework1SpringBootApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    public void productServiceTest() {

        final Product product = productService.getById(1);
        System.out.println(product);
        Assert.assertNotNull(product);
    }

}

