package com.fortalsoft.grocery.service;

import com.fortalsoft.grocery.dto.ProductDTO;
import com.fortalsoft.grocery.entity.Product;
import com.fortalsoft.grocery.exception.ControllerNotFoundException;
import com.fortalsoft.grocery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<ProductDTO> findAll() {
        var products = productRepository.findAll();
        return products.stream().map(this::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO findById(UUID id) {
        Product product = getProduct(id);
        return toProductDTO(product);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = new Product();
        mapperDtoToEntity(productDTO, product);
        product = productRepository.save(product);
        return toProductDTO(product);
    }

    public ProductDTO update(UUID id, ProductDTO productDTO){
        Product product = getProduct(id);
        product.setName(productDTO.name());
        product.setImageUrl(productDTO.imageUrl());
        product = productRepository.save(product);
        return toProductDTO(product);
    }

    private Product getProduct(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Product not found"));
    }

    public void delete(UUID id){
        Product product = getProduct(id);
        productRepository.delete(product);
    }

    private void mapperDtoToEntity(ProductDTO productDTO, Product entity){
        entity.setId(productDTO.id());
        entity.setName(productDTO.name());
        entity.setImageUrl(productDTO.imageUrl());
    }

    private ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getImageUrl());
    }



}
