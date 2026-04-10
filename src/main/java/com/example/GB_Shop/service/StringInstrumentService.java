package com.example.GB_Shop.service;

import com.example.GB_Shop.model.dto.StringInstrumentRequestDto;
import com.example.GB_Shop.model.dto.StringInstrumentResponseDto;
import com.example.GB_Shop.model.entities.StringInstrument;
import com.example.GB_Shop.model.enums.StringInstrumentType;

import java.util.List;

public interface StringInstrumentService {
    public StringInstrumentResponseDto createStringInstrument(StringInstrumentRequestDto dto);
    public List<StringInstrumentResponseDto> getAllStringInstruments();
    public StringInstrumentResponseDto getStringInstrumentById(Long id);
    public StringInstrumentResponseDto updateStringInstrument(Long id, StringInstrumentRequestDto dto);
    public void deleteStringInstrument(Long id);

    public default StringInstrumentResponseDto toDto(StringInstrument stringInstrument){
        return new StringInstrumentResponseDto(
                stringInstrument.getId(),
                stringInstrument.getName(),
                stringInstrument.getModel(),
                stringInstrument.getPrice(),
                stringInstrument.getDescription(),
                stringInstrument.getReleaseYear(),
                stringInstrument.getStatus(),
                stringInstrument.getNumberOfStrings(),
                stringInstrument.getNumberOfFrets(),
                stringInstrument.getWoodType(),
                stringInstrument.getPickupConfig(),
                stringInstrument.getIsLefthanded(),
                stringInstrument.getType()
        );
    }

    public List<StringInstrumentResponseDto> getStringInstrumentByType(StringInstrumentType type);
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfFrets(Integer numberOfFrets);
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfStrings(Integer numberOfStrings);
}
