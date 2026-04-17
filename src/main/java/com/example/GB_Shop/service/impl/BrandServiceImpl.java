package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.dto.BrandRequestDto;
import com.example.GB_Shop.model.dto.BrandResponseDto;
import com.example.GB_Shop.model.entities.Brand;
import com.example.GB_Shop.repository.BrandRepository;
import com.example.GB_Shop.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

//    @Override
//    public BrandResponseDto createBrand(BrandRequestDto dto) {
//        Brand brand = new Brand();
//        brand.setName(dto.name());
//        brand.setCountryOfOrigin(dto.countryOfOrigin());
//
//        return toDto(brandRepository.save(brand));
//    }

    @Override
    public BrandResponseDto createBrand(BrandRequestDto dto) {

        if (brandRepository.existsByName(dto.name())) {
            throw new RuntimeException("Brand already exists with name: " + dto.name());
        }

        Brand brand = new Brand();
        brand.setName(dto.name());
        brand.setCountryOfOrigin(dto.countryOfOrigin());

        return toDto(brandRepository.save(brand));
    }

    @Override
    public List<BrandResponseDto> getAllBrands() {
        return brandRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public BrandResponseDto getBrandById(Long id) {
        return toDto(brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id)));
    }

    @Override
    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new RuntimeException("Brand not found");
        }
        brandRepository.deleteById(id);
    }
}