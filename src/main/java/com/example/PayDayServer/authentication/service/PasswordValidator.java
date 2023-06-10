package com.example.PayDayServer.authentication.service;

import com.example.PayDayServer.authentication.exception.BadPasswordException;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidator {
    public Boolean isPasswordStrong(String password) throws BadPasswordException {
        if(password.length() < 8) throw new BadPasswordException("Password is too short");
        if(password.contains(" ")) throw new BadPasswordException("Password contains whitespaces");
        return true;
    }
}
