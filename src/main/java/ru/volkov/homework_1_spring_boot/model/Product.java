package ru.volkov.homework_1_spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int numenclature;

    @Column
    private String name;

    @Column
    private String description;

    public Product() {
    }

    public int getNumenclature() {
        return numenclature;
    }

    public void setNumenclature(int numenclature) {
        this.numenclature = numenclature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
