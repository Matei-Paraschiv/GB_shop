package com.example.GB_Shop.controller;

import com.example.GB_Shop.model.dto.ProductRequestDto;
import com.example.GB_Shop.model.dto.ProductResponseDto;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

//    @Operation(summary = "Save a product in DB")
//    @PostMapping
//    public ProductResponseDto createProduct(@RequestBody ProductRequestDto dto){
//        return productService.createProduct(dto);
//    }

    @Operation(summary = "Get all products from DB")
    @GetMapping
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @Operation(summary = "Update product")
    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id,@RequestBody ProductRequestDto dto){
        return productService.updateProduct(id, dto);
    }

    @Operation(summary = "Find product by availability")
    @GetMapping("/status/{status}")
    public List<ProductResponseDto> getByStatus(@PathVariable AvailabilityStatus status){
        return productService.getByStatus(status);
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
