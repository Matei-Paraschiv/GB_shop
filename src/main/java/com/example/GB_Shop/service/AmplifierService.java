package com.example.GB_Shop.service;

import com.example.GB_Shop.model.dto.AmplifierRequestDto;
import com.example.GB_Shop.model.dto.AmplifierResponseDto;
import com.example.GB_Shop.model.dto.ProductResponseDto;
import com.example.GB_Shop.model.entities.Amplifier;
import com.example.GB_Shop.model.enums.AmplifierTechnology;

import java.util.List;

public interface AmplifierService {
    public AmplifierResponseDto createAmplifier(AmplifierRequestDto dto);
    public List<AmplifierResponseDto> getAllAmplifiers();
    public AmplifierResponseDto getAmplifierById(Long id);
    public AmplifierResponseDto updateAmplifier(Long id, AmplifierRequestDto dto);
    public void deleteAmplifier(Long id);

    public default AmplifierResponseDto toDto(Amplifier amplifier){
        return new AmplifierResponseDto(
                amplifier.getId(),
                amplifier.getName(),
                amplifier.getModel(),
                amplifier.getPrice(),
                amplifier.getDescription(),
                amplifier.getReleaseYear(),
                amplifier.getStatus().name(),
                amplifier.getWattage(),
                amplifier.getTechnology(),
                amplifier.getEffects()
        );
    }

    public List<AmplifierResponseDto> getAmplifierByTechnology(AmplifierTechnology technology);
    public List<AmplifierResponseDto> findByEffects(boolean hasEffects);
    public List<AmplifierResponseDto> getByWattageBetween(Integer min, Integer max);

}
