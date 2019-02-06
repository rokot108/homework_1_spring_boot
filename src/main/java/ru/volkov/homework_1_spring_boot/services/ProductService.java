package ru.volkov.homework_1_spring_boot.services;

import ru.volkov.homework_1_spring_boot.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(int id);

    boolean existById(int id);

    List<Product> getAll();

    void save(Product entity);

    boolean addNewProduct(Product entity);

    void remove(Product entity);

    void initProduct(int nomenclature, String name, String description);

    Product createNewProduct();
}
