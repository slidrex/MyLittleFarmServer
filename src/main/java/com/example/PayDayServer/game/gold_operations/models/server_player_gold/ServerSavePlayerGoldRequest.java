package com.example.PayDayServer.game.gold_operations.models.server_player_gold;

public class ServerSavePlayerGoldRequest {
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    private Long userId;
    private Long gold;
}
