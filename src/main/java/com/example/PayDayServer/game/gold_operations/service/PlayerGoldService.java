package com.example.PayDayServer.game.gold_operations.service;

import com.example.PayDayServer.authentication.exception.UnknownUser;
import com.example.PayDayServer.authentication.repository.UserRepository;
import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.building.model.BuildingModel;
import com.example.PayDayServer.game.building.repository.BuildingTemplateRepository;
import com.example.PayDayServer.game.gold_operations.models.gold.PlayerGoldResponse;
import com.example.PayDayServer.game.gold_operations.models.gold_per_second.PlayerGPSRequest;
import com.example.PayDayServer.game.gold_operations.models.gold_per_second.PlayerGPSResponse;
import com.example.PayDayServer.game.gold_operations.models.server_player_gold.ServerSavePlayerGoldRequest;
import com.example.PayDayServer.game.plot.entity.PlotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerGoldService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingTemplateRepository buildingTemplateRepository;
    public PlayerGPSResponse getPlayerGoldPerSecond(Long playerId) throws UnknownUser, NoSuchBuildingException, BuildingReachedMaxLevelException {
        
        var user = userRepository.findById(playerId).orElseThrow(() -> new UnknownUser("User doesn't exists"));
        var plots = user.getPlots();
        
        var buildings = plots.get(0).getBuildings();
        List<BuildingModel> buildings_models = new ArrayList<>();
        for(int i = 0; i < buildings.size(); i++)
        {
            var entity = buildings.get(i);
            var model = new BuildingModel(entity.getBuildingId(), entity.getPositionX(),entity.getPositionY(), entity.getBuildingLevel(), entity.getBuildingId());
            buildings_models.add(model);
        }
        
        Long gps = getGoldPerSecond(buildings_models);
        
        return new PlayerGPSResponse(gps + 10L);
    }
    private Long getGoldPerSecond(List<BuildingModel> buildings) throws NoSuchBuildingException, BuildingReachedMaxLevelException {
        Long gps = 0L;
        for (var building:
              buildings) {
            int templateId = building.getBuildingTempalteId();
                var buildingTemplate = buildingTemplateRepository.getByBuildingId(templateId).orElseThrow(() -> new NoSuchBuildingException("No such building with template id: " + templateId));
                if(buildingTemplate == null) throw  new NoSuchBuildingException("No such building with given id!");
                int buildingLevel = building.getLevel() - 1;
                
                gps += buildingTemplate.getBuildingLevels().get(buildingLevel).getGoldPerMinute();
        }
        
        
        return gps;
    }
    public void savePlayerGold(ServerSavePlayerGoldRequest request) throws  UnknownUser{
        var player = userRepository.findById(request.getUserId()).orElseThrow(() -> new UnknownUser("Unknown user!"));
        
        player.setGold(player.getGold() + request.getGold());
        userRepository.save(player);
    }
    public PlayerGoldResponse getPlayerGold(Long id) throws UnknownUser {
        var player = userRepository.findById(id).orElseThrow(() -> new UnknownUser("User not found"));
        var resp = new PlayerGoldResponse(player.getGold());
        return resp;
    }
}
