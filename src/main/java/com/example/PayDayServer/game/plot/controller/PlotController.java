package com.example.PayDayServer.game.plot.controller;

import com.example.PayDayServer.game.plot.service.PlotService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Schema(name = "Plot")
@RequestMapping("plot")
public class PlotController {
    @Autowired
    private PlotService plotService;
    
}
