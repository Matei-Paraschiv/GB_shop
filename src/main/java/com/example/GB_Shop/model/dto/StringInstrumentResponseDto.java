package com.example.GB_Shop.model.dto;

import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.model.enums.StringInstrumentType;

public record StringInstrumentResponseDto(
        Long id,String name, String model, Double price, String description, Integer releaseYear, AvailabilityStatus status,
        Integer numberOfStrings, Integer numberOfFrets, String woodType, String pickupConfig, Boolean isLefthanded, StringInstrumentType type
) {
}
