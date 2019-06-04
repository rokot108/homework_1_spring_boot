package ru.volkov.homework_1_spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int nomenclature;

    @Column
    private String name;

    @Column
    private String description;

    public Product() {
    }

    public int getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(int nomenclature) {
        this.nomenclature = nomenclature;
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

    @Override
    public String toString() {
        return String.format("Nomenclature number %d, Productname %s, Description %s", this.nomenclature, this.name, this.description);
    }
}
