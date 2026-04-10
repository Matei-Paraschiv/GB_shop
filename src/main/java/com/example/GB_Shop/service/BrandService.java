package com.example.GB_Shop.service;

import com.example.GB_Shop.model.dto.BrandRequestDto;
import com.example.GB_Shop.model.dto.BrandResponseDto;
import com.example.GB_Shop.model.entities.Brand;

import java.util.List;

public interface BrandService {
    public BrandResponseDto createBrand(BrandRequestDto dto);
    public List<BrandResponseDto> getAllBrands();
    public BrandResponseDto getBrandById(Long id);
    public void deleteBrand(Long id);

    public default BrandResponseDto toDto(Brand brand) {
        return new BrandResponseDto(
                brand.getId(),
                brand.getName(),
                brand.getCountryOfOrigin()
        );
    }
}