package com.example.PayDayServer.game.gold_operations.controller;

import com.example.PayDayServer.authentication.exception.UnknownUser;
import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.gold_operations.models.gold_per_second.PlayerGPSRequest;
import com.example.PayDayServer.game.gold_operations.service.PlayerGoldService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gold")
@Schema(name = "player-gold-operations")
public class PlayerGoldController {
    @Autowired
    private PlayerGoldService playerGoldService;
    @PostMapping("/get_player_gold_per_second")
    private ResponseEntity<?> getPlayerGoldPerSecond(@RequestBody PlayerGPSRequest request) throws UnknownUser, NoSuchBuildingException, BuildingReachedMaxLevelException {
        var response = playerGoldService.getPlayerGoldPerSecond(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
}
