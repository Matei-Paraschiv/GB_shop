package com.example.GB_Shop.model.dto;

import com.example.GB_Shop.model.enums.AvailabilityStatus;

public record ProductRequestDto(
        String name, String model, Double price, String description, Integer releaseYear, AvailabilityStatus status
) {
}
