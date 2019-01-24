package ru.volkov.homework_1_spring_boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.volkov.homework_1_spring_boot.model.User;

import java.util.List;

public interface UserService {

    User getById(String id);

    List<User> getAll();

    User createNewUser();

    Page<User> findAllPage(Pageable pageable);

    void deleteAll(boolean confirm);

    boolean existsById(String id);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    void save(User entity);

    void remove(User entity);

    void deleteById(String id);

    User getUserByLogin(String login);

    void initUser(String login, String password, String email, String... roles);
}
