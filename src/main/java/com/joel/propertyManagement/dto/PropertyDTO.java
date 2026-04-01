package com.joel.propertyManagement.dto;

import com.joel.propertyManagement.controller.PropertyPhoto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PropertyDTO {
    private String id;

    @NotNull
    @Size(min = 5, max = 50, message = "Property title has to be between 5 and 50 characters!")
    private String title;

    @NotNull
    @Size(min = 20, max = 1000, message = "Property description has to be between 20 and 1000 characters!")
    private String description;

    @NotNull(message = "Property must have at least 1 photo")
    @Size(min = 1, message = "Property must have at least 1 photo")
    private List<PropertyPhoto> photos;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Size(min = 5, max = 100, message = "Property address has to be between 5 and 100 characters!")
    private String address;

    private String userId;
}