package com.example.GB_Shop.model.entities;

import com.example.GB_Shop.model.enums.KeyboardInstrumentType;
import jakarta.persistence.*;

@Entity
@Table(name = "keyboard_instruments")
public class KeyboardInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfKeys;
    private String keyAction;

    private KeyboardInstrumentType keyboardInstrumentType;
}
