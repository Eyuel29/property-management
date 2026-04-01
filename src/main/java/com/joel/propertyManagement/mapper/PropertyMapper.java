package com.joel.propertyManagement.mapper;

import com.joel.propertyManagement.dto.PropertyDTO;
import com.joel.propertyManagement.entity.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    @Mapping(source = "user.id", target = "userId")
    PropertyDTO toDTO(Property property);

    @Mapping(source = "userId", target = "user.id")
    Property toEntity(PropertyDTO dto);
}
