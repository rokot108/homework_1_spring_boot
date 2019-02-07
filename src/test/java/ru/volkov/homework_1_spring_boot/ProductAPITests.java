package ru.volkov.homework_1_spring_boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.context.WebApplicationContext;
import ru.volkov.homework_1_spring_boot.model.Product;
import ru.volkov.homework_1_spring_boot.model.User;
import ru.volkov.homework_1_spring_boot.services.ProductService;
import ru.volkov.homework_1_spring_boot.services.UserService;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductAPITests {

    @Autowired
    MockMvc mvc;

    @MockBean
    ProductService productService;

    @MockBean
    UserService userService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Before
    public void setUp() {

        Product product = new Product();
        product.setNomenclature(5);
        product.setName("Kolbasa");
        product.setDescription("Krakovskaya");

        Mockito.when(productService.existById(5)).thenReturn(true);
        Mockito.when(productService.getById(5)).thenReturn(product);

        User user = new User();
        user.setId("1");
        user.setLogin("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRoles(new String[]{"USER"});
        user.setEmail("test@yandex.ru");

        Mockito.when(userService.getUserByLogin("user")).thenReturn(user);
        Mockito.when(userService.getById("1")).thenReturn(user);
    }

    @Test
    @WithMockUser
    public void getProductAPITesting() throws Exception {

        RequestBuilder requestBuilder = (ServletContext servletContext) -> {
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.setRequestURI("/api/product/5");
            request.setServerPort(8080);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Requested URL is: " + request.getRequestURL());
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            request.setMethod("GET");
            // request.addHeader("Authorization", "Basic dXNlcjp1c2Vy");
            request.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
            return request;
        };

        mvc
                .perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void goToUsersPage() throws Exception {

        RequestBuilder requestBuilder = (ServletContext servletContext) -> {
            MockHttpServletRequest request = new MockHttpServletRequest();
            request.setRequestURI("/users");
            request.setServerPort(8080);
            request.setMethod("GET");
            request.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
            return request;
        };

        mvc
                .perform(requestBuilder)
                .andExpect(status().isOk());
    }

}
