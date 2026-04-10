package com.example.GB_Shop.controller;

import com.example.GB_Shop.model.dto.BrandRequestDto;
import com.example.GB_Shop.model.dto.BrandResponseDto;
import com.example.GB_Shop.service.impl.BrandServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandServiceImpl brandService;

    @Operation(summary = "Save a brand")
    @PostMapping
    public BrandResponseDto createBrand(@RequestBody BrandRequestDto dto) {
        return brandService.createBrand(dto);
    }

    @Operation(summary = "Get all brands")
    @GetMapping
    public List<BrandResponseDto> getAllBrands() {
        return brandService.getAllBrands();
    }

    @Operation(summary = "Get brand by id")
    @GetMapping("/{id}")
    public BrandResponseDto getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @Operation(summary = "Delete a brand")
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
    }
}