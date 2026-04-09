package com.example.GB_Shop.repository;

import com.example.GB_Shop.model.entities.Product;
import com.example.GB_Shop.model.enums.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> getByStatus(AvailabilityStatus status);

}