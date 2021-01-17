package com.game.carcassonne.carcassonnegame.players;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.board.WrongPutException;
import com.game.carcassonne.carcassonnegame.squares.EmptySquare;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.Squares;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Square setSquare(Board board, Square square) {

        int i = 0;
        int column = 9999;
        int raw = 9999;
        while (i == 0) {
            board.showAvailableSquares(square);
            System.out.println("Pick place to put your square or rotate it (write: right, left or column:raw)");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("right")) {
                square = Square.copyAndTurnRightSquare(square);
            } else if (input.equals("left")) {
                square = Square.copyAndTurnLeftSquare(square);
            } else if (input.indexOf(":") == 1 || input.indexOf(":") == 2) {
                int colon = input.indexOf(":");
                column = Integer.parseInt(input.substring(0, colon));
                raw = Integer.parseInt(input.substring(colon+1));
                i = 9;
            } else {
                System.out.println("Wrong input. Try again.");
            }
        }
        square.setColumn(column);
        square.setRaw(raw);
        return square;
    }

    public void turn(Board board, Square square) {

        square = setSquare(board, square);
        int column = square.getColumn();
        int raw = square.getRaw();
        try {
            board.putSquare(column, raw, square);
        } catch (WrongPutException e) {
            System.out.println(e);
        }
        System.out.println(column + ":" + raw + square);
//        Part part = setPawnPosition();
//        square.putPawn(part);
//        board.calculate();
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
