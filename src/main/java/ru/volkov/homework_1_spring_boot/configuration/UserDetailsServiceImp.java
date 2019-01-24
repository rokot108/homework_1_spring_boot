package ru.volkov.homework_1_spring_boot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volkov.homework_1_spring_boot.services.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserService userService;

    @Transactional
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {

        if (userLogin == null || userLogin.isEmpty()) throw new UsernameNotFoundException("User not found");

        final ru.volkov.homework_1_spring_boot.model.User user = userService.getUserByLogin(userLogin);
        UserBuilder builder = null;
        builder = User.withUsername(userLogin);
        builder.password(user.getPassword());
        builder.roles(user.getRoles());
        return builder.build();
    }
}
