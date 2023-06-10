package com.example.PayDayServer.game.building.model.levelup;

public class LevelUpRequest {
    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    private Long buildingId;
}
