package com.joel.projectManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;
    private String address;
}
