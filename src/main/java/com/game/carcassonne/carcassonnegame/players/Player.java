package com.game.carcassonne.carcassonnegame.players;

public class Player {

    private final String color;
    private int points = 0;
    private int numberOfPawns = 7;

    public Player(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
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

    @Override
    public String toString() {
        return "Player{" +
                "color='" + color + '\'' +
                ", points=" + points +
                ", numberOfPawns=" + numberOfPawns +
                '}';
    }
}
