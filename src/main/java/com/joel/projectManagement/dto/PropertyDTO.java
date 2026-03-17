package com.joel.projectManagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PropertyDTO {
    private String id;
    @NotNull @Size(min = 5, max = 50, message = "Property title has to be between 5 and 50 characters!") private String title;
    @NotNull @Size(min = 20, max = 1000, message = "Property description has to be between 20 and 1000 characters!") private String description;
    @NotNull private BigDecimal price;
    @NotNull @Size(min = 5, max = 100, message = "Property address has to be between 5 and 100 characters!") private String address;
    private String userId;
}
