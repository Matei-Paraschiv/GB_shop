package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.dto.ProductRequestDto;
import com.example.GB_Shop.model.dto.ProductResponseDto;
import com.example.GB_Shop.model.entities.Product;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.repository.ProductRepository;
import com.example.GB_Shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

//    @Override
//    public ProductResponseDto createProduct(ProductRequestDto dto) {
//
//        Product product = new Product();
//        product.setName(dto.name());
//        product.setModel(dto.model());
//        product.setPrice(dto.price());
//        product.setDescription(dto.description());
//        product.setReleaseYear(dto.releaseYear());
//        product.setStatus(dto.status());
//
//        Product savedProduct = productRepository.save(product);
//
//        return toDto(savedProduct);
//    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return toDto(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with this id: " + id)));
    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) {
        Product productFound = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
        productFound.setName(dto.name());
        productFound.setPrice(dto.price());
        productFound.setModel(dto.model());
        productFound.setDescription(dto.description());
        productFound.setStatus(dto.status());
        productFound.setReleaseYear(dto.releaseYear());

        return toDto(productRepository.save(productFound));
    }

    @Override
    public List<ProductResponseDto> getByStatus(AvailabilityStatus status) {

        return productRepository.getByStatus(status).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        productRepository.deleteById(id);
    }


}
