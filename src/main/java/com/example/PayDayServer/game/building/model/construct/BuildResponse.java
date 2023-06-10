package com.example.PayDayServer.game.building.model.construct;

public class BuildResponse {
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

    public Long getPlotID() {
        return plotID;
    }

    public void setPlotID(Long plotID) {
        this.plotID = plotID;
    }

    public Long getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Long buildingID) {
        this.buildingID = buildingID;
    }

    private int positionX;
    private int positionY;
    private Long plotID;
    private Long buildingID;
}
