package ru.volkov.homework_1_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.volkov.homework_1_spring_boot.model.User;
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

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable String id) {
        final UserDetails loggedInUser = (UserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if (loggedInUser != null) {
            final String loggedUserName = loggedInUser.getUsername();
            final User user = userService.getUserByLogin(loggedUserName);
            if (user != null && (user.getLogin().equals(loggedUserName) || user.hasRole("ADMIN"))) {
                userService.deleteById(id);
                if (!user.hasRole("ADMIN")) {
                    SecurityContextHolder.clearContext();
                }
            }
            return "redirect:/users";
        }
        return "/login";
    }
}
