package com.example.GB_Shop.model.dto;

public record AmplifierResponseDto(
        Long id, String name, Integer wattage, String technology, boolean hasEffects
) {
}
