package com.example.GB_Shop.repository;

import com.example.GB_Shop.model.entities.StringInstrument;
import com.example.GB_Shop.model.enums.StringInstrumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StringInstrumentRepository extends JpaRepository<StringInstrument, Long> {
    List<StringInstrument> findByType(StringInstrumentType type);
    List<StringInstrument> findByNumberOfFrets(Integer numberOfFrets);
    List<StringInstrument> findByNumberOfStrings(Integer numberOfStrings);
}