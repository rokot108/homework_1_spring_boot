package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volkov.homework_1_spring_boot.model.User;
import ru.volkov.homework_1_spring_boot.services.UserService;

import javax.validation.Valid;

@Controller
public class CreateEditUserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}/user_edit")
    public ModelAndView createOrEditUser(@PathVariable String id,
                                         ModelAndView modelAndView) {

        if (id == null || id.isEmpty() || !userService.existsById(id)) {
            modelAndView.addObject("msg", "New user registration");
            modelAndView.addObject("user", userService.createNewUser());
            modelAndView.setViewName("/user_edit");
            return modelAndView;
        }

        modelAndView.addObject("msg", "User data edit page");
        modelAndView.addObject("user", userService.getById(id));
        return modelAndView;
    }


    @PostMapping("/user_edit")
    public String saveUser(@Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user_edit";
        }
        userService.save(user);
        return "redirect:/users";
    }

}
