package com.example.PayDayServer.game.building.exception.level;

public class BuildingReachedMaxLevelException extends Exception{
    public BuildingReachedMaxLevelException() {
        super("Building has a max level");
    }
}
