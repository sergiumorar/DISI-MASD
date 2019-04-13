package com.masd.masd.controller;

import com.masd.masd.error.ErrorResponse;
import com.masd.masd.model.dto.UserDto;
import com.masd.masd.model.dto.UserLoginDto;
import com.masd.masd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity login(@RequestBody UserLoginDto user) {
        UserDto persistedUser = userService.login(user);
        return persistedUser == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Optional.of(buildErrorMessage())) : ResponseEntity.ok(persistedUser);
    }

    private ErrorResponse buildErrorMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("401");
        errorResponse.setDescription("invalid credentials");
        return errorResponse;
    }
}
