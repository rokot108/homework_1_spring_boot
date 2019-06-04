package ru.volkov.homework_1_spring_boot.dto;

public class ProductDTO {
    private int nomenclature;

    private String name;

    private String description;

    public ProductDTO() {
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
}
