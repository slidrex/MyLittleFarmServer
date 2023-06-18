package com.example.PayDayServer.game.building.model;

public class BuildingModel {
    private int positionX;
    private int positionY;
    private int level;
    private int buildingTempalteId;

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }

    private long buildingId;

    public BuildingModel(long buildingId, int positionX, int positionY, int level, int buildingTempalteId) {
        this.positionX = positionX;
        this.buildingId = buildingId;
        this.positionY = positionY;
        this.level = level;
        this.buildingTempalteId = buildingTempalteId;
    }

    public BuildingModel() {
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBuildingTempalteId() {
        return buildingTempalteId;
    }

    public void setBuildingTempalteId(int buildingTempalteId) {
        this.buildingTempalteId = buildingTempalteId;
    }
}
