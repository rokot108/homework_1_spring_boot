package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volkov.homework_1_spring_boot.services.UserService;

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView allUsersPage(ModelAndView modelAndView) {

        modelAndView.addObject(userService.getAll());
        modelAndView.setViewName("users");

        return modelAndView;
    }

}
