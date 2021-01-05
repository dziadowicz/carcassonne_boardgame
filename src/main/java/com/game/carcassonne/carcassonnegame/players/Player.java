package com.game.carcassonne.carcassonnegame.players;

public class Player {

    private String color;
    private int points;

    public Player(String color, int points) {
        this.color = color;
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
