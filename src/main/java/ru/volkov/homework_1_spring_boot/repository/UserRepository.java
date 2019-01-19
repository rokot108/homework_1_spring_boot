package ru.volkov.homework_1_spring_boot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.volkov.homework_1_spring_boot.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findByLogin(String login);

    User getById(String id);

    boolean existsById(String id);

    boolean existsByLogin(String login);
}
