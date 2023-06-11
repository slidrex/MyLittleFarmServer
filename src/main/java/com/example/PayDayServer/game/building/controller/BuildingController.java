package com.example.PayDayServer.game.building.controller;

import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.building.model.construct.BuildRequest;
import com.example.PayDayServer.game.building.model.deconstruct.DeconstructRequest;
import com.example.PayDayServer.game.building.model.levelup.LevelUpRequest;
import com.example.PayDayServer.game.building.model.levelup.LevelUpResponse;
import com.example.PayDayServer.game.building.repository.BuildingTemplateRepository;
import com.example.PayDayServer.game.building.service.BuildingService;
import com.example.PayDayServer.game.plot.exception.NoSuchPlotException;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.coyote.Response;
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
    private ResponseEntity<?> createBuilding(BuildRequest request) throws NoSuchPlotException {
        var response = buildingService.build(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deconstruct")
    private ResponseEntity<?> deconstructBuilding(DeconstructRequest request) throws NoSuchBuildingException {
        var response = buildingService.destroyBuilding(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/level_up")
    private ResponseEntity<?> levelUpBuilding(LevelUpRequest request) throws NoSuchBuildingException, BuildingReachedMaxLevelException {
        var response = buildingService.upgradeBuilding(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
