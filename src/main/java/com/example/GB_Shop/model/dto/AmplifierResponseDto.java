package com.example.GB_Shop.model.dto;

public record AmplifierResponseDto(
        Long id, String name, String model, Double price, String description, Integer releaseYear, String status, Integer wattage, String technology, Boolean hasEffects
) {}
