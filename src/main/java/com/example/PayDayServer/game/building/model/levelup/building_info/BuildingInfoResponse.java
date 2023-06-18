package com.example.PayDayServer.game.building.model.levelup.building_info;

public class BuildingInfoResponse {
    private String buildingName;
    private int templateId;
    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    private int buildingLevel;

    public BuildingInfoResponse(String buildingName, int level, int templateId, int goldPerSecond) {
        this.buildingName = buildingName;
        this.buildingLevel = level;
        this.templateId = templateId;
        this.goldPerSecond = goldPerSecond;
    }

    private int goldPerSecond;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getGoldPerSecond() {
        return goldPerSecond;
    }

    public void setGoldPerSecond(int goldPerSecond) {
        this.goldPerSecond = goldPerSecond;
    }
}
