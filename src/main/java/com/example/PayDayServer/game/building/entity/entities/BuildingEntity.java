package com.example.PayDayServer.game.building.entity.entities;

import com.example.PayDayServer.game.plot.entity.PlotEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "constructed_building")
public class BuildingEntity {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int positionX;
    private int positionY;
    @Column(name = "building_id")
    private int buildingId;
    @Column(name = "building_level")
    private int buildingLevel;
    @ManyToOne
    @JoinColumn(name = "build_id")
    private PlotEntity plot;

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

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }
}
