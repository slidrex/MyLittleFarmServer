package com.example.PayDayServer.game.plot.service;

import com.example.PayDayServer.authentication.repository.UserRepository;
import com.example.PayDayServer.game.plot.entity.PlotEntity;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import com.example.PayDayServer.game.plot.model.expand.PlotExpandRequest;
import com.example.PayDayServer.game.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlotService {
    @Autowired
    private PlotRepository plotRepository;
    public void expandPlot(PlotExpandRequest request) throws NoSuchPlotException {
        var plot = plotRepository.findById(request.getPlotId()).orElseThrow(() -> new NoSuchPlotException("No such plot!"));
        if(request.isHorizontalExpand())
            plot.setSizeX(plot.getSizeX() + 1);
        else plot.setSizeY(plot.getSizeY() + 1);
        plotRepository.save(plot);
    }
}
