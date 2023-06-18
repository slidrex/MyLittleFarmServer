package com.example.PayDayServer.game.building.controller;

import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.building.model.construct.BuildRequest;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructRequest;
import com.example.PayDayServer.game.building.model.levelup.LevelUpRequest;
import com.example.PayDayServer.game.building.service.BuildingService;
import com.example.PayDayServer.game.gold_operations.exception.NotEnoughGoldException;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Schema(name = "build-controller")
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/build")
    private ResponseEntity<?> createBuilding(@RequestBody BuildRequest request) throws NoSuchPlotException, NoSuchBuildingException, NotEnoughGoldException {
        
        var response = buildingService.build(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deconstruct")
    private ResponseEntity<?> deconstructBuilding(@RequestBody DeconstructRequest request) throws NoSuchBuildingException {
        var response = buildingService.destroyBuilding(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/get_building_next_level_info/{building_id}")
    private ResponseEntity<?> getUpgradeBuildingLevelInfo(@PathVariable Long building_id) throws NoSuchBuildingException, BuildingReachedMaxLevelException {
        var response = buildingService.getNextBuildingLevelInfo(building_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/get_building_info/{building_id}")
    private ResponseEntity<?> getBuildingInfo(@PathVariable Long building_id) throws NoSuchBuildingException {
        var response = buildingService.getBuildingInfo(building_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PatchMapping("/level_up")
    private ResponseEntity<?> levelUpBuilding(@RequestBody LevelUpRequest request) throws NoSuchBuildingException, BuildingReachedMaxLevelException, NotEnoughGoldException {
        var response = buildingService.upgradeBuilding(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
