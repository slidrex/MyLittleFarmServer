package com.example.PayDayServer.game.gold_operations.exception;

public class NotEnoughGoldException extends Exception{

    public NotEnoughGoldException() {
        super("Not enough gold!");
    }
}
