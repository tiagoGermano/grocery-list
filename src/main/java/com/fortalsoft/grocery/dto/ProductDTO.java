package com.fortalsoft.grocery.dto;

import com.fortalsoft.grocery.entity.Product;
import com.fortalsoft.grocery.enums.MeasureType;

import java.util.UUID;

public class ProductDTO {

    private UUID id;
    private String name;
    private String imageUrl;
    private MeasureType measureType;
    private DepartmentDTO department;

    public ProductDTO(UUID id, String name, String imageUrl, DepartmentDTO department, MeasureType measureType) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.measureType = measureType;
        this.department = department;
    }

    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getImageUrl(),
                new DepartmentDTO(product.getDepartment().getId(), product.getDepartment().getName()), product.getMeasureType());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

}