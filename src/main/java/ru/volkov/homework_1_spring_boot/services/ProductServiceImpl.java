package ru.volkov.homework_1_spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volkov.homework_1_spring_boot.model.Product;
import ru.volkov.homework_1_spring_boot.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;


    @Override
    public Product getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void save(Product entity) {

    }

    @Override
    public void remove(Product entity) {

    }

    @Override
    public void initProduct(int nomenclature, String name, String description) {
        if (repository.existsById(nomenclature)) return;
        Product product = createNewProduct();
        product.setNumenclature(nomenclature);
        product.setName(name);
        product.setDescription(description);
        repository.save(product);
    }

    @Override
    public Product createNewProduct() {
        return new Product();
    }
}
