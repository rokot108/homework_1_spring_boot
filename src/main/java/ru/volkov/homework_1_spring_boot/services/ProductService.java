package ru.volkov.homework_1_spring_boot.services;

import ru.volkov.homework_1_spring_boot.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(int id);

    List<Product> getAll();

    void save(Product entity);

    void remove(Product entity);

    void initProduct(int nomenclature, String name, String description);

    Product createNewProduct();
}
