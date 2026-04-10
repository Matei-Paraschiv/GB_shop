package com.example.GB_Shop.model.entities;

import com.example.GB_Shop.model.enums.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;
    private Double price;
    private String description;
    private Integer releaseYear;

    private AvailabilityStatus status;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}