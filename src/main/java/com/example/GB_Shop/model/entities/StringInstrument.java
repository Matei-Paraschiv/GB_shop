package com.example.GB_Shop.model.entities;

import com.example.GB_Shop.model.enums.StringInstrumentType;
import jakarta.persistence.*;

@Entity
@Table(name = "string_instruments") // Sau doar "guitars"
public class StringInstrument extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer numberOfStrings;
    private Integer numberOfFrets;
    private String woodType;
    private String pickupConfig;
    private Boolean isLefthanded;

    private StringInstrumentType type;
}