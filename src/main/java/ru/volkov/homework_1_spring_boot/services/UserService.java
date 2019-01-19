package ru.volkov.homework_1_spring_boot.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.volkov.homework_1_spring_boot.model.User;

public interface UserService extends ServiceInterface<User> {

    User createNewUser();

    Page<User> findAllPage(Pageable pageable);

    void deleteAll(boolean confirm);

    boolean existsById(String id);

    boolean existsByLogin(String login);

    void save(User entity);

    void remove(User entity);

    User getUserByLogin(String login);

    void initUser(String login, String password, String email);
}
