package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.entities.Product;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.GB_Shop.model.enums.AvailabilityStatus.NOT_AVAILABLE;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productFound = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());
        productFound.setModel(product.getModel());
        productFound.setReleaseYear(product.getReleaseYear());

        return productRepository.save(productFound);
    }

    @Override
    public List<Product> findByStatus(AvailabilityStatus status) {

        List<Product> productList = productRepository.findByStatus(status);

        if (productList.isEmpty()){
            throw new RuntimeException("Product not available");
        }

        return productList;

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
