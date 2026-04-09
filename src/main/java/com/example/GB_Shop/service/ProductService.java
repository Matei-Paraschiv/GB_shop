package com.example.GB_Shop.service;

import com.example.GB_Shop.model.dto.ProductRequestDto;
import com.example.GB_Shop.model.dto.ProductResponseDto;
import com.example.GB_Shop.model.entities.Product;
import com.example.GB_Shop.model.enums.AvailabilityStatus;

import java.util.List;

public interface ProductService {

//    public ProductResponseDto createProduct(ProductRequestDto dto);
    public List<ProductResponseDto> getAllProducts(); //si basuri si chitare'
    public ProductResponseDto getProductById(Long id);
    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto);
    public List<ProductResponseDto> getByStatus(AvailabilityStatus status);
    public void deleteProduct(Long id);

    public default ProductResponseDto toDto(Product product){
        ProductResponseDto dto = new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getModel(),
                product.getPrice(),
                product.getDescription(),
                product.getReleaseYear(),
                product.getStatus()
        );
        return dto;
    }
}
