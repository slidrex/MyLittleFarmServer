package com.example.PayDayServer.authentication.exception;

public class UserExistsException extends Exception{
    public UserExistsException(String message) {
        super(message);
    }
}
