package com.joel.projectManagement.converter;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public Property convertDTOToEntity (PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());
        property.setTitle(propertyDTO.getTitle());
        property.setPrice(propertyDTO.getPrice());

        return property;
    }
}
