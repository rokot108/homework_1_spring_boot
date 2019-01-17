package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volkov.homework_1_spring_boot.model.User;
import ru.volkov.homework_1_spring_boot.services.UserService;

import javax.validation.Valid;
import java.time.LocalTime;

@Controller
public class CreateEditUserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}/user_edit")
    public ModelAndView createOrEditUser(@PathVariable String id,
                                         ModelAndView modelAndView) {

        if (id == null || id.isEmpty() || !userService.existsById(id)) {
            modelAndView.addObject("msg", "New user registration");
            modelAndView.addObject("time", LocalTime.now());
            modelAndView.addObject("msg1", "New message");
            modelAndView.addObject("msg34455vegehreahjsrtejiik", "New message");
            modelAndView.addObject("user", userService.createNewUser());
            modelAndView.setViewName("user_edit");
            return modelAndView;
        }

        modelAndView.addObject("msg", "User data edit page");
        modelAndView.addObject(userService.getById(id));
        return modelAndView;
    }


    @PostMapping("{id}/user_edit")
    public String saveUser(@PathVariable String id,
                           @Valid User user) {

        return "users";
    }

}
