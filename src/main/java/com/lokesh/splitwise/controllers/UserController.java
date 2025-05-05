package com.lokesh.splitwise.controllers;

import com.lokesh.splitwise.dtos.ResponseStatus;
import com.lokesh.splitwise.dtos.SignUpRequestDTO;
import com.lokesh.splitwise.dtos.SignUpResponseDTO;
import com.lokesh.splitwise.models.User;
import com.lokesh.splitwise.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();

        try {
            User user = userService.signUp(signUpRequestDTO.getName(),
                        signUpRequestDTO.getEmail(),
                        signUpRequestDTO.getPassword());
            signUpResponseDTO.setUser(user);
            signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            signUpResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDTO;
    }
}
