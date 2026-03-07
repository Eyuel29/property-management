package com.joel.projectManagement.controller;

import com.joel.projectManagement.dto.PropertyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {
    @PostMapping("/property")
    public ResponseEntity<PropertyDTO> createProperty (@RequestBody PropertyDTO newProperty) {
        System.out.println(newProperty);
        return new ResponseEntity(newProperty, HttpStatus.CREATED);
    }
}
