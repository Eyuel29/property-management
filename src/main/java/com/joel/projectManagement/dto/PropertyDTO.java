package com.joel.projectManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PropertyDTO {
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String address;
}
