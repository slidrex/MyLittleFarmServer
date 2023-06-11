package com.example.PayDayServer.game.plot.exception_handler;

import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlotExceptionHandler {
    @ExceptionHandler(NoSuchPlotException.class)
    private ResponseEntity<?> noSuchPlotExceptionHandler(NoSuchPlotException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
