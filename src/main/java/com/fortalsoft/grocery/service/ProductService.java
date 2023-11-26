package com.fortalsoft.grocery.service;

import com.fortalsoft.grocery.dto.DepartmentDTO;
import com.fortalsoft.grocery.dto.ProductDTO;
import com.fortalsoft.grocery.entity.Product;
import com.fortalsoft.grocery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductDTO> {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Override
    ProductDTO mapperEntityToDTO(Product product) {
        return new ProductDTO(product);
    }

    @Override
    void mapperDTOToEntity(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setImageUrl(productDTO.getImageUrl());
        product.getDepartment().setId(productDTO.getDepartment().getId());
        product.getDepartment().setName(productDTO.getDepartment().getName());
    }

    @Override
    Product createEntity() {
        return new Product();
    }

    @Override
    JpaRepository getRepository() {
        return this.repository;
    }
}
