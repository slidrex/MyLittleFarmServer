package com.example.PayDayServer.game.plot.entity;

import com.example.PayDayServer.authentication.entity.UserEntity;
import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plot")
public class PlotEntity {
    public PlotEntity(int sizeX, int sizeY, UserEntity user) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.user = user;
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
    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL)
    private List<BuildingEntity> buildings;
}
