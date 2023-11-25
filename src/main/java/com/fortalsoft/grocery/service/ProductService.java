package com.fortalsoft.grocery.service;

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
        return new ProductDTO(product.getId(), product.getName(), product.getImageUrl());
    }

    @Override
    void mapperDTOToEntity(Product entity, ProductDTO productDTO) {
        entity.setName(productDTO.name());
        entity.setImageUrl(productDTO.imageUrl());
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
