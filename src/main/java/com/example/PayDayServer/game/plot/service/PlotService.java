package com.example.PayDayServer.game.plot.service;

import com.example.PayDayServer.authentication.repository.UserRepository;
import com.example.PayDayServer.game.plot.entity.PlotEntity;
import com.example.PayDayServer.game.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlotService {
    @Autowired
    private PlotRepository plotRepository;
}
