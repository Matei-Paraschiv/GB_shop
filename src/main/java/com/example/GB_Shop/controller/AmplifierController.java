package com.example.GB_Shop.controller;

import com.example.GB_Shop.model.dto.AmplifierRequestDto;
import com.example.GB_Shop.model.dto.AmplifierResponseDto;
import com.example.GB_Shop.model.enums.AmplifierTechnology;
import com.example.GB_Shop.service.impl.AmplifierServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/amplifiers")
public class AmplifierController {

    private final AmplifierServiceImpl amplifierService;

    @Operation(summary = "Save an amplifier in DB")
    @PostMapping
    public AmplifierResponseDto createAmplifier(@RequestBody AmplifierRequestDto dto){
        return amplifierService.createAmplifier(dto);
    }

    @Operation(summary = "Get all amplifiers from DB")
    @GetMapping
    public List<AmplifierResponseDto> getAllAmplifiers(){
        return amplifierService.getAllAmplifiers();
    }

    @Operation(summary = "Get an amplifier by id")
    @GetMapping("/{id}")
    public AmplifierResponseDto getAmplifierById(@PathVariable Long id){
        return amplifierService.getAmplifierById(id);
    }

    @Operation(summary = "Update an amplifier")
    @PutMapping("/{id}")
    public AmplifierResponseDto updateAmplifier(@PathVariable Long id,@RequestBody AmplifierRequestDto dto){
        return amplifierService.updateAmplifier(id, dto);
    }

    @Operation(summary = "Delete an amplifier")
    @DeleteMapping("/{id}")
    public void deleteAmplifier(Long id){
        amplifierService.deleteAmplifier(id);
    }

    @Operation(summary = "Get an amplifier by technology")
    @GetMapping("/technology/{technology}")
    public List<AmplifierResponseDto> getAmplifierByTechnology(@PathVariable AmplifierTechnology technology){
        return amplifierService.getAmplifierByTechnology(technology);
    }

    @Operation(summary = "Get an amplifier with/without effects")
    @GetMapping("/hasEffects/{hasEffects}")
    public List<AmplifierResponseDto> findByEffects(@PathVariable boolean withEffects){
        return amplifierService.findByEffects(withEffects);
    }

    @Operation(summary = "Get an amplifier by wattage range")
    @GetMapping("/wattage")
    public List<AmplifierResponseDto> getByWattageBetween(@RequestParam Integer min, @RequestParam Integer max) {
        return amplifierService.getByWattageBetween(min, max);
    }


}
