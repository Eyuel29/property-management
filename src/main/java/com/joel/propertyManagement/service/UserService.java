package com.joel.propertyManagement.service;

import com.joel.propertyManagement.dto.UserDTO;
import com.joel.propertyManagement.exception.PMSException;

public interface UserService {
    UserDTO signIn (String email, String password) throws PMSException;
    UserDTO signUp (UserDTO userDTO) throws PMSException;
}
