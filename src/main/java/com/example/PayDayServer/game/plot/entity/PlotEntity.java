package com.example.PayDayServer.game.plot.entity;

import com.example.PayDayServer.authentication.entity.UserEntity;
import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import com.example.PayDayServer.game.building.model.BuildingModel;
import com.example.PayDayServer.game.plot.model.PlotModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plot")
public class PlotEntity {
    public PlotEntity(int sizeX, int sizeY, UserEntity user) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.user = user;
    }
    public static PlotModel getModel(PlotEntity entity){
        var buildings = entity.getBuildings();
        
        List<BuildingModel> buildingsModels = new ArrayList<BuildingModel>();
        for (var building :
              buildings) {
            var model = new BuildingModel(building.getId(), building.getPositionX(), building.getPositionY(), building.getBuildingLevel(), building.getBuildingId());
            buildingsModels.add(model);
            
        }
        var model = new PlotModel(entity.getSizeX(), entity.getSizeY(), entity.getId(), entity.getUser(), buildingsModels);
        
        return model;
    }
    public PlotEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int sizeX;
    private int sizeY;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }

    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL)
    private List<BuildingEntity> buildings;
}
