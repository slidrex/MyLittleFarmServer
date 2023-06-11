package com.example.PayDayServer.game.building.exception_handler;

import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BuildingExceptionsHandler {
    @ExceptionHandler({NoSuchBuildingException.class, BuildingReachedMaxLevelException.class})
    private ResponseEntity<?> noSuchBuildingExceptionHandler(Exception exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
