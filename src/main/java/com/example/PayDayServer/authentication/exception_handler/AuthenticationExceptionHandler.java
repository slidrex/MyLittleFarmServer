package com.example.PayDayServer.authentication.exception_handler;

import com.example.PayDayServer.authentication.exception.BadPasswordException;
import com.example.PayDayServer.authentication.exception.PasswordMismatchException;
import com.example.PayDayServer.authentication.exception.UnknownUser;
import com.example.PayDayServer.authentication.exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    @ExceptionHandler({PasswordMismatchException.class, UserExistsException.class, BadPasswordException.class, UserExistsException.class})
    private ResponseEntity<?> passwordMismatchExceptionHandler(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
