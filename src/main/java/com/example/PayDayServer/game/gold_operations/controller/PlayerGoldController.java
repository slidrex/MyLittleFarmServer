package com.example.PayDayServer.game.gold_operations.controller;

import com.example.PayDayServer.authentication.exception.UnknownUser;
import com.example.PayDayServer.game.building.exception.NoSuchBuildingException;
import com.example.PayDayServer.game.building.exception.level.BuildingReachedMaxLevelException;
import com.example.PayDayServer.game.gold_operations.models.gold_per_second.PlayerGPSRequest;
import com.example.PayDayServer.game.gold_operations.models.server_player_gold.ServerSavePlayerGoldRequest;
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
    @GetMapping("/get_player_gold_per_second/{id}")
    private ResponseEntity<?> getPlayerGoldPerSecond(@PathVariable Long id) throws UnknownUser, NoSuchBuildingException, BuildingReachedMaxLevelException {
        var response = playerGoldService.getPlayerGoldPerSecond(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/get_player_gold/{id}")
    private ResponseEntity<?> getPlayerGold(@PathVariable Long id) throws UnknownUser {
        var response = playerGoldService.getPlayerGold(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/save_player_gold")
    private ResponseEntity<?> savePlayerGold(@RequestBody ServerSavePlayerGoldRequest request) throws UnknownUser {
        playerGoldService.savePlayerGold(request);
        return new ResponseEntity<>("Successful transaction", HttpStatus.OK);
    }
}
