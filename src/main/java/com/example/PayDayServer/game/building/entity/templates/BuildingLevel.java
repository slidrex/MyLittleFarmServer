package com.example.PayDayServer.game.building.entity.templates;

import jakarta.persistence.Column;
import org.springframework.data.mongodb.core.mapping.Field;

public class BuildingLevel {
    @Field(name = "gold_cost")
    private int goldCost;

    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public int getMaxGold() {
        return maxGold;
    }

    public void setMaxGold(int maxGold) {
        this.maxGold = maxGold;
    }

    public int getGoldPerMinute() {
        return goldPerMinute;
    }

    public void setGoldPerMinute(int goldPerMinute) {
        this.goldPerMinute = goldPerMinute;
    }

    @Field(name = "max_gold")
    private int maxGold;
    @Field(name = "gold_per_minute")
    private int goldPerMinute;
}
