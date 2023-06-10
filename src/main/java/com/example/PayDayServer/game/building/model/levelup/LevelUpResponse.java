package com.example.PayDayServer.game.building.model.levelup;

public class LevelUpResponse {
    public LevelUpResponse(int buildingId, int newLevel) {
        this.buildingId = buildingId;
        this.newLevel = newLevel;
    }

    private int buildingId;

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(int newLevel) {
        this.newLevel = newLevel;
    }

    private int newLevel;
}
