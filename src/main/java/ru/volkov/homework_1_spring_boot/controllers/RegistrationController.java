package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.volkov.homework_1_spring_boot.model.User;
import ru.volkov.homework_1_spring_boot.services.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registrationRequested(Model model) {
        model.addAttribute("user", userService.createNewUser());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@Valid User user, BindingResult bindingResult) {

        if (userService.existsByEmail(user.getEmail())) {
            bindingResult.addError(new FieldError("User", "email", "User with email " + user.getEmail() + " already exists"));
        }

        if (userService.existsByLogin(user.getLogin())) {
            bindingResult.addError(new FieldError("User", "login", "User with login " + user.getLogin() + " already exists"));
        }
        if (!bindingResult.hasErrors()) {
            final String password = user.getPassword();
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(new String[]{"USER"});
            userService.save(user);
            return "/login";
        }
        return "registration";
    }

}
