package com.example.GB_Shop.service.impl;

import com.example.GB_Shop.model.dto.StringInstrumentRequestDto;
import com.example.GB_Shop.model.dto.StringInstrumentResponseDto;
import com.example.GB_Shop.model.entities.Brand;
import com.example.GB_Shop.model.entities.StringInstrument;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import com.example.GB_Shop.model.enums.StringInstrumentType;
import com.example.GB_Shop.repository.BrandRepository;
import com.example.GB_Shop.repository.StringInstrumentRepository;
import com.example.GB_Shop.service.StringInstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StringInstrumentServiceImpl implements StringInstrumentService {

    public final StringInstrumentRepository stringInstrumentRepository;
    private final BrandRepository brandRepository;

    @Override
    public StringInstrumentResponseDto createStringInstrument(StringInstrumentRequestDto dto) {
        StringInstrument stringInstrument = new StringInstrument();

        Brand brand = brandRepository.findById(dto.brand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));

        stringInstrument.setName(dto.name());
        stringInstrument.setModel(dto.model());
        stringInstrument.setPrice(dto.price());
        stringInstrument.setDescription(dto.description());
        stringInstrument.setReleaseYear(dto.releaseYear());
        stringInstrument.setStatus(dto.status());

        stringInstrument.setNumberOfStrings(dto.numberOfStrings());
        stringInstrument.setNumberOfFrets(dto.numberOfFrets());
        stringInstrument.setWoodType(dto.woodType());
        stringInstrument.setPickupConfig(dto.pickupConfig());
        stringInstrument.setIsLefthanded(dto.isLefthanded());
        stringInstrument.setType(dto.type());

        stringInstrument.setBrand(brand);

        StringInstrument savedStringInstrument = stringInstrumentRepository.save(stringInstrument);
        return toDto(savedStringInstrument);
    }

    @Override
    public List<StringInstrumentResponseDto> getAllStringInstruments() {
        return stringInstrumentRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public StringInstrumentResponseDto getStringInstrumentById(Long id) {
        return toDto(stringInstrumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No String Instrument has been found with id: " + id)));
    }

    @Override
    public StringInstrumentResponseDto updateStringInstrument(Long id, StringInstrumentRequestDto dto) {

        StringInstrument instrumentFound = stringInstrumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No String Instrument has been found with id: " + id));

        Brand brand = brandRepository.findById(dto.brand_id())
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));

        instrumentFound.setName(dto.name());
        instrumentFound.setModel(dto.model());
        instrumentFound.setPrice(dto.price());
        instrumentFound.setDescription(dto.description());
        instrumentFound.setReleaseYear(dto.releaseYear());
        instrumentFound.setStatus(dto.status());

        instrumentFound.setNumberOfStrings(dto.numberOfStrings());
        instrumentFound.setNumberOfFrets(dto.numberOfFrets());
        instrumentFound.setWoodType(dto.woodType());
        instrumentFound.setPickupConfig(dto.pickupConfig());
        instrumentFound.setIsLefthanded(dto.isLefthanded());
        instrumentFound.setType(dto.type());

        instrumentFound.setBrand(brand);

        return toDto(stringInstrumentRepository.save(instrumentFound));

    }

    @Override
    public void deleteStringInstrument(Long id) {
        stringInstrumentRepository.deleteById(id);
    }

    @Override
    public List<StringInstrumentResponseDto> getStringInstrumentByType(StringInstrumentType type) {
        return stringInstrumentRepository.findByType(type).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfFrets(Integer numberOfFrets) {
        return stringInstrumentRepository.findByNumberOfFrets(numberOfFrets).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfStrings(Integer numberOfStrings) {
        return stringInstrumentRepository.findByNumberOfStrings(numberOfStrings)
                .stream()
                .map(this::toDto)
                .toList();
    }
}
