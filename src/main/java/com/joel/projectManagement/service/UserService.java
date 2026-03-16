package com.joel.projectManagement.service;

import com.joel.projectManagement.dto.UserDTO;
import com.joel.projectManagement.exception.PMSException;

public interface UserService {
    UserDTO signIn (String email, String password) throws PMSException;
    UserDTO signUp (UserDTO userDTO) throws PMSException;
}
