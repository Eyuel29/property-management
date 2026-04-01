package com.joel.propertyManagement.entity;

import com.joel.propertyManagement.controller.PropertyPhoto;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "pm_property")
@Getter
@Setter
@NoArgsConstructor
public class Property {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(name = "title", nullable = false) private String title;
    @Column(name = "description", nullable = false) private String description;
    @Column(name = "price", nullable = false) private BigDecimal price;
    @Column(name = "address", nullable = false) private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) private User user;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyPhoto> photos = new ArrayList<>();


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
