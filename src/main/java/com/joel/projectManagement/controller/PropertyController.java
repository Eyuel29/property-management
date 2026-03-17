package com.joel.projectManagement.controller;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.exception.PMSException;
import com.joel.projectManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/property")
    public ResponseEntity<List<PropertyDTO>> getAllProperties () {
        List<PropertyDTO> properties = propertyService.getAllProperties();
        return new ResponseEntity(properties, HttpStatus.OK);
    }

    @PostMapping("/property")
    public ResponseEntity<PropertyDTO> createProperty (@RequestBody PropertyDTO newProperty) throws PMSException {
        propertyService.saveProperty(newProperty);
        return new ResponseEntity(newProperty, HttpStatus.CREATED);
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDTO> getPropertyById (@PathVariable String propertyId) {
        PropertyDTO result = propertyService.getPropertyById(propertyId);
        if (result == null) return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/property-by-user/{userId}")
    public ResponseEntity<PropertyDTO> getAllUserProperties (@PathVariable String userId) {
        System.out.println(userId);
        List<PropertyDTO> properties = propertyService.getAllUserProperties(userId);
        return new ResponseEntity(properties, HttpStatus.OK);
    }

    @PutMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty (@RequestBody PropertyDTO modifiedProperty, @PathVariable(name = "propertyId") String propertyId) {
        PropertyDTO result = propertyService.updateProperty(propertyId, modifiedProperty);
        return new ResponseEntity(result, result == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @DeleteMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDTO> deletePropertyById (@PathVariable(name = "propertyId") String propertyId) {
        propertyService.deletePropertyById(propertyId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
