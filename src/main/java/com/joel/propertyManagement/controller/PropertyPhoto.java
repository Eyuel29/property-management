package com.joel.propertyManagement.controller;

import com.joel.propertyManagement.entity.Property;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@Table(name = "pm_property_photo")
@Getter
@Setter
@NoArgsConstructor
public class PropertyPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(name = "alt", nullable = false) private String alt;
    @Column(name = "src", nullable = false) private String src;

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "property_id", nullable = false) private Property property;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
