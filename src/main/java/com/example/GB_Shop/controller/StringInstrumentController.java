package com.example.GB_Shop.controller;

import com.example.GB_Shop.model.dto.StringInstrumentRequestDto;
import com.example.GB_Shop.model.dto.StringInstrumentResponseDto;
import com.example.GB_Shop.model.enums.StringInstrumentType;
import com.example.GB_Shop.service.impl.StringInstrumentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/string-instruments")
public class StringInstrumentController {

    private final StringInstrumentServiceImpl stringInstrumentService;

    @Operation(summary = "Save a string instrument in DB")
    @PostMapping
    public StringInstrumentResponseDto createStringInstrument(@RequestBody StringInstrumentRequestDto dto){
        return stringInstrumentService.createStringInstrument(dto);
    }

    @Operation(summary = "Get all string instruments from DB")
    @GetMapping
    public List<StringInstrumentResponseDto> getAllStringInstruments(){
        return stringInstrumentService.getAllStringInstruments();
    }

    @Operation(summary = "Get a string instrument by id")
    @GetMapping("/{id}")
    public StringInstrumentResponseDto getStringInstrumentById(@PathVariable Long id){
        return stringInstrumentService.getStringInstrumentById(id);
    }

    @Operation(summary = "Update a string instrument")
    @PutMapping("/{id}")
    public StringInstrumentResponseDto updateStringInstrument(@PathVariable Long id, @RequestBody StringInstrumentRequestDto dto){
        return stringInstrumentService.updateStringInstrument(id, dto);
    }

    @Operation(summary = "Delete a string instrument")
    @DeleteMapping("/{id}")
    public void deleteStringInstrument(@PathVariable Long id){
        stringInstrumentService.deleteStringInstrument(id);
    }

    @Operation(summary = "Get string instruments by type")
    @GetMapping("/type/{type}")
    public List<StringInstrumentResponseDto> getStringInstrumentByType(@PathVariable StringInstrumentType type){
        return stringInstrumentService.getStringInstrumentByType(type);
    }

    @Operation(summary = "Get string instruments by number of frets")
    @GetMapping("/frets/{numberOfFrets}")
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfFrets(@PathVariable Integer numberOfFrets){
        return stringInstrumentService.getStringInstrumentByNumberOfFrets(numberOfFrets);
    }

    @Operation(summary = "Get string instruments by number of strings")
    @GetMapping("/strings/{numberOfStrings}")
    public List<StringInstrumentResponseDto> getStringInstrumentByNumberOfStrings(@PathVariable Integer numberOfStrings){
        return stringInstrumentService.getStringInstrumentByNumberOfStrings(numberOfStrings);
    }
}