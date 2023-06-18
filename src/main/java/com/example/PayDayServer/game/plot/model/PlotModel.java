package com.example.PayDayServer.game.plot.model;

import com.example.PayDayServer.authentication.entity.UserEntity;
import com.example.PayDayServer.game.building.model.BuildingModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class PlotModel {
    public PlotModel(int sizeX, int sizeY, long plotId, UserEntity user, List<BuildingModel> buildings) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.plotId = plotId;
        this.userID = user.getId();
        this.buildings = buildings;
    }

    private int sizeX;
    private int sizeY;
    private Long userID;
    private Long plotId;
    private List<BuildingModel> buildings;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public PlotModel() {
    }


    public List<BuildingModel> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingModel> buildings) {
        this.buildings = buildings;
    }
}
