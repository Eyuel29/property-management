package com.joel.projectManagement.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "property_table")
@Getter
@Setter
@NoArgsConstructor
public class Property {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(name = "title", nullable = false) private String title;
    @Column(name = "description", nullable = false) private String description;
    @Column(name = "price", nullable = false) private BigDecimal price;
    private String address;
}
