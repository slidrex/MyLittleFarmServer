package com.example.PayDayServer.game.gold_operations.models.gold;

public class PlayerGoldResponse {
    public PlayerGoldResponse(Long gold) {
        this.gold = gold;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    private Long gold;
}
