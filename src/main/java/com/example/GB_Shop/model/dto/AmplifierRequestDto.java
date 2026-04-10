package com.example.GB_Shop.model.dto;

import com.example.GB_Shop.model.enums.AmplifierTechnology;

public record AmplifierRequestDto(
        String name , Integer wattage, Double price, Integer releaseYear, String status, String model, String description, AmplifierTechnology technology, Boolean hasEffects,
        Long brand_id
) {
}
