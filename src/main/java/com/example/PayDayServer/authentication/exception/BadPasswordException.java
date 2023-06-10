package com.example.PayDayServer.authentication.exception;

public class BadPasswordException extends Exception{
    public BadPasswordException(String message) {
        super(message);
    }
}
