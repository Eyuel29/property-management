package com.joel.projectManagement.mapper;

import com.joel.projectManagement.dto.PropertyDTO;
import com.joel.projectManagement.entity.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyDTO toDTO(Property property);
    Property toEntity(PropertyDTO propertyDTO);
}
