package com.joel.projectManagement.mapper;

import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO (User user);
    User toEntity (UserDTO userDTO);
}
