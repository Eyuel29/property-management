package com.joel.propertyManagement.controller;

import com.joel.propertyManagement.dto.UserDTO;
import com.joel.propertyManagement.exception.PMSException;
import com.joel.propertyManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<UserDTO> signUp (@Valid @RequestBody UserDTO newUser) throws PMSException {
        UserDTO result = userService.signUp(newUser);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/user/signin")
    public ResponseEntity<UserDTO> signIn (@Valid @RequestBody UserDTO userDTO) throws PMSException {

        UserDTO foundUser = userService.signIn(userDTO.getEmail(), userDTO.getPassword());
        if (foundUser == null) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        if (!foundUser.getPassword().equals(userDTO.getPassword())) return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}
