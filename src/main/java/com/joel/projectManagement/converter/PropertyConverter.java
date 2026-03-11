package com.joel.projectManagement.converter;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public Property convertDTOToEntity (PropertyDTO propertyDTO) {
        Property property = new Property();

        property.setId(propertyDTO.getId());
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());
        property.setTitle(propertyDTO.getTitle());
        property.setPrice(propertyDTO.getPrice());

        return property;
    }

    public PropertyDTO convertEntityToDTO (Property property) {
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(property.getId());
        propertyDTO.setAddress(property.getAddress());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setTitle(property.getTitle());
        propertyDTO.setPrice(property.getPrice());

        return propertyDTO;
    }
}
