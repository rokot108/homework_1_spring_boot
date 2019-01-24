package ru.volkov.homework_1_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.volkov.homework_1_spring_boot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
