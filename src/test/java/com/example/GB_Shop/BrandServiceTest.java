package com.example.GB_Shop;

import com.example.GB_Shop.model.dto.BrandRequestDto;
import com.example.GB_Shop.model.dto.BrandResponseDto;
import com.example.GB_Shop.model.entities.Brand;
import com.example.GB_Shop.repository.BrandRepository;
import com.example.GB_Shop.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandServiceImpl brandService;

    @Test
    void createBrand_success() {
        // given
        BrandRequestDto requestDto = new BrandRequestDto("Fender", "USA");

        when(brandRepository.existsByName("Fender")).thenReturn(false);

        Brand savedBrand = new Brand();
        savedBrand.setId(1L);
        savedBrand.setName("Fender");
        savedBrand.setCountryOfOrigin("USA");

        when(brandRepository.save(any(Brand.class))).thenReturn(savedBrand);

        // when
        BrandResponseDto responseDto = brandService.createBrand(requestDto);

        // then
        assertNotNull(responseDto);
        assertEquals(1L, responseDto.id());
        assertEquals("Fender", responseDto.name());

        verify(brandRepository).existsByName("Fender");
        verify(brandRepository).save(any(Brand.class));
    }

    @Test
    void createBrand_alreadyExists() {
        // given
        BrandRequestDto requestDto = new BrandRequestDto("Fender", "USA");

        when(brandRepository.existsByName("Fender")).thenReturn(true);

        // when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            brandService.createBrand(requestDto);
        });

        // then
        assertEquals("Brand already exists with name: Fender", exception.getMessage());

        verify(brandRepository, never()).save(any(Brand.class));
    }

    @Test
    void getBrandById_notFound() {
        // given
        Long id = 99L;
        when(brandRepository.findById(id)).thenReturn(Optional.empty());

        // when
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            brandService.getBrandById(id);
        });

        // then
        assertEquals("Brand not found with id: " + id, exception.getMessage());
        verify(brandRepository).findById(id);
    }
}