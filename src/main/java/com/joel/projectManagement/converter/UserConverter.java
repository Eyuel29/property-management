package com.joel.projectManagement.converter;

import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User convertDTOToEntity (UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());

        return user;
    }

    public UserDTO convertEntityToDTO (User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());

        return userDTO;
    }
}
