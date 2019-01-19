package ru.volkov.homework_1_spring_boot.services;

import java.util.List;

public interface ServiceInterface<T> {

    T getById(String id);

    List<T> getAll();

    void save(T entity);

    void remove(T entity);

}
