package com.game.carcassonne.carcassonnegame.players;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.squares.EmptySquare;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.Squares;

import java.util.ArrayList;
import java.util.List;

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
