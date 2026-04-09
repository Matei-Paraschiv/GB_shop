package com.example.GB_Shop.repository;

import com.example.GB_Shop.model.dto.AmplifierResponseDto;
import com.example.GB_Shop.model.entities.Amplifier;
import com.example.GB_Shop.model.enums.AmplifierTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmplifierRepository extends JpaRepository<Amplifier, Long> {
    public List<Amplifier> getAmplifierByTechnology(AmplifierTechnology technology);
    public List<Amplifier> findByEffects(Boolean effects);
    public List<Amplifier> getByWattageBetween(Integer min, Integer max);
}
