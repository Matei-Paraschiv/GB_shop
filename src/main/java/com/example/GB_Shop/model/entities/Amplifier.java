package com.example.GB_Shop.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "amplifiers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Amplifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer wattage; //voltaj
    private String technology; //pe lampi sau altfel
    private boolean hasEffects;


}