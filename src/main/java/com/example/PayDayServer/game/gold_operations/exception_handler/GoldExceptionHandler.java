package com.example.PayDayServer.game.gold_operations.exception_handler;

import com.example.PayDayServer.game.gold_operations.exception.NotEnoughGoldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GoldExceptionHandler {
    @ExceptionHandler(NotEnoughGoldException.class)
    private ResponseEntity<?> goldExceptionHandler(NotEnoughGoldException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

}
