package com.joel.projectManagement.controller;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/property")
    public ResponseEntity<PropertyDTO> createProperty (@RequestBody PropertyDTO newProperty) {
        System.out.println(newProperty);
        propertyService.createProperty(newProperty);
        return new ResponseEntity(newProperty, HttpStatus.CREATED);
    }
}
