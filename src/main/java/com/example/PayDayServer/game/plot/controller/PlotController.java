package com.example.PayDayServer.game.plot.controller;

import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import com.example.PayDayServer.game.plot.model.expand.PlotExpandRequest;
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
    @PostMapping("/expand_plot")
    private ResponseEntity<?> expandPlot(@RequestBody PlotExpandRequest request) throws NoSuchPlotException {
        plotService.expandPlot(request);
        return new ResponseEntity<>("Expanded", HttpStatus.OK);
    }
    
}
