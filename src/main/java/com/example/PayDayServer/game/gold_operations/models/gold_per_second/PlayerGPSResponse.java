package com.example.PayDayServer.game.gold_operations.models.gold_per_second;

import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import com.example.PayDayServer.game.building.model.BuildingModel;

import java.util.List;

public class PlayerGPSResponse {
    public Long getGoldPerSecond() {
        return goldPerSecond;
    }

    public void setGoldPerSecond(Long goldPerSecond) {
        this.goldPerSecond = goldPerSecond;
    }

    public PlayerGPSResponse(Long goldPerSecond) {
        this.goldPerSecond = goldPerSecond;
    }

    private Long goldPerSecond;
}
