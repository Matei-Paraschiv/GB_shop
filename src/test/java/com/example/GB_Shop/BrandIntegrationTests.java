package com.example.GB_Shop;

import com.example.GB_Shop.model.dto.BrandRequestDto;
import com.example.GB_Shop.model.entities.Brand;
import com.example.GB_Shop.repository.BrandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class BrandIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandRepository brandRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        brandRepository.deleteAll();
    }

    @AfterEach
    void cleanUp() {
        brandRepository.deleteAll();
    }

    @Test
    void whenCreateValidBrand_thenReturnBrand() throws Exception {
        BrandRequestDto dto = new BrandRequestDto("Fender", "USA");

        mockMvc.perform(post("/api/brands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Fender"))
                .andExpect(jsonPath("$.countryOfOrigin").value("USA"));

        assertEquals(1, brandRepository.count());
    }

    @Test
    void whenCreateDuplicateBrand_thenThrowException() throws Exception {
        Brand existingBrand = new Brand();
        existingBrand.setName("Gibson");
        existingBrand.setCountryOfOrigin("USA");
        brandRepository.save(existingBrand);

        BrandRequestDto dto = new BrandRequestDto("Gibson", "China");

        assertThrows(Exception.class, () ->
                mockMvc.perform(post("/api/brands")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto)))
                        .andExpect(status().isInternalServerError()));

        assertEquals(1, brandRepository.count());
    }

    @Test
    void whenGetAllBrands_thenReturnList() throws Exception {
        Brand brand = new Brand();
        brand.setName("Ibanez");
        brand.setCountryOfOrigin("Japan");
        brandRepository.save(brand);

        mockMvc.perform(get("/api/brands"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("Ibanez"));
    }
}