package com.game.carcassonne.carcassonnegame.players;

public class Player {

    private String color;
    private int points;
    private int numberOfPawns;

    public Player(String color, int points, int numberOfPawns) {
        this.color = color;
        this.points = points;
        this.numberOfPawns = numberOfPawns;
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

    public int getNumberOfPawns() {
        return numberOfPawns;
    }

    public void setNumberOfPawns(int numberOfPawns) {
        this.numberOfPawns = numberOfPawns;
    }
}
