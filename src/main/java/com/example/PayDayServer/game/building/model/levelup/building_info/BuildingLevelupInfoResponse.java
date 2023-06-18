package com.example.PayDayServer.game.building.model.levelup.building_info;

public class BuildingLevelupInfoResponse {
    private int newGoldPerSecond;

    public int getOldGoldPerSecond() {
        return oldGoldPerSecond;
    }

    public void setOldGoldPerSecond(int oldGoldPerSecond) {
        this.oldGoldPerSecond = oldGoldPerSecond;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    private String buildingName;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    private Long buildingId;
    private int oldGoldPerSecond;
    private int newLevel;
    private int cost;

    public BuildingLevelupInfoResponse(Long buildingId,String buildingName, int oldGoldPerSecond, int newGoldPerSecond, int newLevel, int cost) {
        this.newGoldPerSecond = newGoldPerSecond;
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.oldGoldPerSecond = oldGoldPerSecond;
        this.newLevel = newLevel;
        this.cost = cost;
    }

    public int getNewGoldPerSecond() {
        return newGoldPerSecond;
    }

    public void setNewGoldPerSecond(int newGoldPerSecond) {
        this.newGoldPerSecond = newGoldPerSecond;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(int newLevel) {
        this.newLevel = newLevel;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
