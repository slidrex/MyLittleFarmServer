package com.example.PayDayServer.authentication.controller;

import com.example.PayDayServer.authentication.model.login.LoginRequest;
import com.example.PayDayServer.authentication.model.register.RegisterRequest;
import com.example.PayDayServer.authentication.service.AuthenticationService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Schema(name = "Authentication")
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    private ResponseEntity<?> createUser(@RequestBody RegisterRequest registerRequest) {
        try {
            var registerResponse = authenticationService.register(registerRequest);
            return new ResponseEntity<>(registerResponse, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    private ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest) {
        try
        {
            var response = authenticationService.authenticate(loginRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
