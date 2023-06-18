package com.example.PayDayServer.authentication.model.login;

import com.example.PayDayServer.game.building.model.BuildingModel;
import com.example.PayDayServer.game.plot.entity.PlotEntity;
import com.example.PayDayServer.game.plot.model.PlotModel;

import java.util.ArrayList;
import java.util.List;

public class LoginResponse {
    private String login;
    private Long gold;
    private PlotModel plot;
    public LoginResponse(String login, Long gold, List<PlotEntity> plot_entities) {
        this.login = login;
        this.gold = gold;
        
        plot = PlotEntity.getModel(plot_entities.get(0));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PlotModel getPlot() {
        return plot;
    }

    public void setPlot(PlotModel plot) {
        this.plot = plot;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }
}
