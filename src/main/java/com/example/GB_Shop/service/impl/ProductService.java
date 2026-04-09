package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.entities.Product;
import com.example.GB_Shop.model.enums.AvailabilityStatus;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);
    public List<Product> getAllProducts(); //si basuri si chitare'
    public Product getProductById(Long id);
    public Product updateProduct(Long id, Product product);
    public List<Product> findByStatus(AvailabilityStatus status);
    public void deleteProduct(Long id);

}
