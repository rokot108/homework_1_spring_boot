package ru.volkov.homework_1_spring_boot.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.volkov.homework_1_spring_boot.model.User;
import ru.volkov.homework_1_spring_boot.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User createNewUser() {
        return new User();
    }

    @Override
    public Page<User> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteAll(boolean confirm) {
        if (confirm) repository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByLogin(String login) {
        return repository.existsByLogin(login);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public void save(User entity) {
        repository.save(entity);
    }

    @Override
    public void remove(User entity) {
        repository.delete(entity);
    }

    @Override
    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public void initUser(String login, String password, String email, String... roles) {
        if (repository.existsByLogin(login)) {
            return;
        }
        User user = createNewUser();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoles(roles);
        repository.save(user);
    }

    @Override
    public User getById(String id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(repository.findAll());
    }
}
