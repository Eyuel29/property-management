package com.joel.propertyManagement.mapper;

import com.joel.propertyManagement.dto.UserDTO;
import com.joel.propertyManagement.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO (User user);
    User toEntity (UserDTO userDTO);
}
