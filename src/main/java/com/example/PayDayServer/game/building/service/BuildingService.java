package com.example.PayDayServer.game.building.service;

import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.building.model.BuildingModel;
import com.example.PayDayServer.game.building.model.construct.BuildRequest;
import com.example.PayDayServer.game.building.model.construct.BuildResponse;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructRequest;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructResponse;
import com.example.PayDayServer.game.building.model.levelup.LevelUpRequest;
import com.example.PayDayServer.game.building.model.levelup.LevelUpResponse;
import com.example.PayDayServer.game.building.model.levelup.building_info.BuildingInfoResponse;
import com.example.PayDayServer.game.building.model.levelup.building_info.BuildingLevelupInfoResponse;
import com.example.PayDayServer.game.building.repository.BuildingRepository;
import com.example.PayDayServer.game.building.repository.BuildingTemplateRepository;
import com.example.PayDayServer.game.gold_operations.exception.NotEnoughGoldException;
import com.example.PayDayServer.game.gold_operations.service.GoldOperationsService;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import com.example.PayDayServer.game.plot.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    @Autowired
    private BuildingTemplateRepository buildingRepository;
    @Autowired
    private BuildingRepository constructedBuildingsRepository;
    @Autowired
    private PlotRepository plotRepository;
    @Autowired
    private GoldOperationsService goldOperationsService;
    @Autowired
    private GoldOperationsService playerGoldOperations;
    public BuildingModel build(BuildRequest buildRequest) throws NoSuchBuildingException, NoSuchPlotException, NotEnoughGoldException {

        var plot = plotRepository.findById(buildRequest.getPlotId()).orElseThrow(() -> new NoSuchPlotException("No such plot"));
        var buildingTemplate = buildingRepository.getByBuildingId(buildRequest.getBuildingID()).orElseThrow(() -> new NoSuchBuildingException("Unknown building")); 

        var user = plot.getUser();

        long buildingCost = buildingTemplate.getBuildingLevels().get(0).getGoldCost();
        goldOperationsService.trySpendMoney(user, buildingCost);

        var building = new BuildingEntity();
        building.setBuildingLevel(1);

        building.setPositionX(buildRequest.getPositionX());
        building.setPositionY(buildRequest.getPositionY());
        building.setPlot(plot);

        constructedBuildingsRepository.save(building);
        var response = new BuildingModel(buildRequest.getBuildingID(), buildRequest.getPositionX(), buildRequest.getPositionY(), 1, buildingTemplate.getBuildingId());
        
        
        return response;
    }
    public BuildingInfoResponse getBuildingInfo(Long id) throws NoSuchBuildingException {
        var constructedBuilding = constructedBuildingsRepository.findById(id).orElseThrow(() -> new NoSuchBuildingException("Unknown building"));
        var buildingTemplate = buildingRepository.getByBuildingId(constructedBuilding.getBuildingId()).orElseThrow(() -> new NoSuchBuildingException("Unknown building template"));
        return new BuildingInfoResponse(buildingTemplate.getBuildingName(), constructedBuilding.getBuildingLevel(), buildingTemplate.getBuildingId(), buildingTemplate.getBuildingLevels().get(constructedBuilding.getBuildingLevel() - 1).getGoldPerMinute());
    }
    public BuildingLevelupInfoResponse getNextBuildingLevelInfo(Long id) throws NoSuchBuildingException, BuildingReachedMaxLevelException {
        var building = constructedBuildingsRepository.findById(id).orElseThrow(() -> new NoSuchBuildingException("Unknown building"));
        int newLevel = building.getBuildingLevel() + 1;
        var buildingTemplate = buildingRepository.getByBuildingId(building.getBuildingId()).orElseThrow(() -> new NoSuchBuildingException("Unknown building template"));
        var buildingLevels = buildingTemplate.getBuildingLevels();
        if(buildingLevels.size() <= newLevel - 1) throw new BuildingReachedMaxLevelException();
        var newBuilding = buildingLevels.get(newLevel - 1);
        var oldBuilding = buildingLevels.get(newLevel - 2);
        
        return new BuildingLevelupInfoResponse(building.getId(), buildingTemplate.getBuildingName(), oldBuilding.getGoldPerMinute(), newBuilding.getGoldPerMinute(), newLevel, newBuilding.getGoldCost());
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
    public LevelUpResponse upgradeBuilding(LevelUpRequest request) throws NoSuchBuildingException, BuildingReachedMaxLevelException, NotEnoughGoldException {
        
        var building = constructedBuildingsRepository.findById(request.getBuildingId()).orElseThrow(() -> new NoSuchBuildingException("No building with specified id!"));
        var user = building.getPlot().getUser();
        
        int newLevel = building.getBuildingLevel() + 1;
            
        var buildingTemplate = buildingRepository.getByBuildingId(building.getBuildingId()).orElseThrow(() -> new NoSuchBuildingException("Building template doesn't exist!"));
        
        if(buildingTemplate.getBuildingLevels().size() <= newLevel - 1) throw new BuildingReachedMaxLevelException();
        long buildingCost = buildingTemplate.getBuildingLevels().get(newLevel - 1).getGoldCost();
        playerGoldOperations.trySpendMoney(user, buildingCost);
        
        building.setBuildingLevel(newLevel);
        constructedBuildingsRepository.save(building);
        var resp = new LevelUpResponse(building.getBuildingId(), newLevel);
        return resp;
    }
            
}
    
