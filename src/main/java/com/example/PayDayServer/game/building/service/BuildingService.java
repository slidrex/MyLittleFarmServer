package com.example.PayDayServer.game.building.service;

import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.model.construct.BuildRequest;
import com.example.PayDayServer.game.building.model.construct.BuildResponse;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructRequest;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructResponse;
import com.example.PayDayServer.game.building.model.levelup.LevelUpRequest;
import com.example.PayDayServer.game.building.model.levelup.LevelUpResponse;
import com.example.PayDayServer.game.building.repository.BuildingRepository;
import com.example.PayDayServer.game.building.repository.BuildingTemplateRepository;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import com.example.PayDayServer.game.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingTemplateRepository buildingRepository;
    @Autowired
    private BuildingRepository constructedBuildingsRepository;
    @Autowired
    private PlotRepository plotRepository;
    public BuildResponse build(BuildRequest buildRequest) throws NoSuchPlotException {
        var plot = plotRepository.findById(buildRequest.getPlotId());
        if(plot.isEmpty()) throw new NoSuchPlotException("No such plot");
        var building = new BuildingEntity();
        building.setBuildingLevel(1);
        building.setPositionX(buildRequest.getPositionX());
        building.setPositionY(buildRequest.getPositionY());

        constructedBuildingsRepository.save(building);
        var response = new BuildResponse();
        response.setPositionX(0);
        response.setPositionY(0);
        response.setPlotID(buildRequest.getPlotId());
        return response;
    }
    public DeconstructResponse destroyBuilding(DeconstructRequest request) throws NoSuchBuildingException
    {
        var building = constructedBuildingsRepository.findById(request.getConstructedBuildingId());
        if(building.isEmpty()) throw new NoSuchBuildingException("No building with specified id!");
        else 
        {
            constructedBuildingsRepository.delete(building.get());
            return new DeconstructResponse(request.getConstructedBuildingId());
        }
            
    }
    public LevelUpResponse upgradeBuilding(LevelUpRequest request) throws NoSuchBuildingException {
        var building = constructedBuildingsRepository.findById(request.getBuildingId());
        if(building.isEmpty()) throw new NoSuchBuildingException("No building with specified id!");
        else 
        {
            var building_obj = building.get();
            int newLevel = building_obj.getBuildingLevel() + 1;
            building_obj.setBuildingLevel(newLevel);
            constructedBuildingsRepository.save(building_obj);
            var resp = new LevelUpResponse(building_obj.getBuildingId(), newLevel);
            return resp;
        }
            
    }

}