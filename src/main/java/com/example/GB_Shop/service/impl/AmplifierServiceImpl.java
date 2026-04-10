package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.dto.AmplifierRequestDto;
import com.example.GB_Shop.model.dto.AmplifierResponseDto;
import com.example.GB_Shop.model.entities.Amplifier;
import com.example.GB_Shop.model.entities.Brand;
import com.example.GB_Shop.model.enums.AmplifierTechnology;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.repository.AmplifierRepository;
import com.example.GB_Shop.repository.BrandRepository;
import com.example.GB_Shop.service.AmplifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmplifierServiceImpl implements AmplifierService {

    private final AmplifierRepository amplifierRepository;
    private final BrandRepository brandRepository;

    @Override
    public AmplifierResponseDto createAmplifier(AmplifierRequestDto dto) {

        Brand brand = brandRepository.findById(dto.brand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));

        Amplifier amplifier = new Amplifier();

        amplifier.setName(dto.name());
        amplifier.setModel(dto.model());
        amplifier.setPrice(dto.price());
        amplifier.setDescription(dto.description());
        amplifier.setReleaseYear(dto.releaseYear());
        amplifier.setStatus(AvailabilityStatus.valueOf(dto.status()));

        amplifier.setWattage(dto.wattage());
        amplifier.setTechnology(String.valueOf(dto.technology()));
        amplifier.setEffects(dto.hasEffects());

        Amplifier savedAmp = amplifierRepository.save(amplifier);
        return toDto(savedAmp);
    }

    @Override
    public List<AmplifierResponseDto> getAllAmplifiers() {
        return amplifierRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public AmplifierResponseDto getAmplifierById(Long id) {
        return toDto(amplifierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amplifier not found with this id: " + id)));
    }

    @Override
    public AmplifierResponseDto updateAmplifier(Long id, AmplifierRequestDto dto) {
        Amplifier ampFound = amplifierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amplifier not found with this id: " + id));

        Brand brand = brandRepository.findById(dto.brand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));

        ampFound.setName(dto.name());
        ampFound.setModel(dto.model());
        ampFound.setPrice(dto.price());
        ampFound.setDescription(dto.description());
        ampFound.setReleaseYear(dto.releaseYear());
        ampFound.setStatus(AvailabilityStatus.valueOf(dto.status()));

        ampFound.setWattage(dto.wattage());
        ampFound.setTechnology(String.valueOf(dto.technology()));
        ampFound.setEffects(dto.hasEffects());

        ampFound.setBrand(brand);

        return toDto(amplifierRepository.save(ampFound));
    }

    @Override
    public void deleteAmplifier(Long id) {
        if (!amplifierRepository.existsById(id)) {
            throw new RuntimeException("Amplifier not found");
        }

        amplifierRepository.deleteById(id);
    }

    //implementarile noi adaugate acu
    @Override
    public List<AmplifierResponseDto> getAmplifierByTechnology(AmplifierTechnology technology) {
        return amplifierRepository.getAmplifierByTechnology(technology).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<AmplifierResponseDto> findByEffects(boolean withEffects) {
        return amplifierRepository.findByEffects(withEffects).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<AmplifierResponseDto> getByWattageBetween(Integer min, Integer max) {
        return amplifierRepository.getByWattageBetween(min, max).stream()
                .map(this::toDto)
                .toList();
    }
}
