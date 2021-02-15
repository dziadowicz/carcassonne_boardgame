package com.game.carcassonne.carcassonnegame.players;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.board.WrongPutException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.parts.EmptyPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

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
            System.out.println("\nPick place to put your square or rotate it (write: right, left or column:raw)");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("right")) {
                square = Square.copyAndTurnRightSquare(square);
            } else if (input.equals("left")) {
                square = Square.copyAndTurnLeftSquare(square);
            } else if (input.indexOf(":") == 1 || input.indexOf(":") == 2) {
                int colon = input.indexOf(":");
                column = Integer.parseInt(input.substring(0, colon));
                raw = Integer.parseInt(input.substring(colon+1)); //exception
                i = 9;
            } else {
                System.out.println("Wrong input. Try again.");
            }
        }
        square.setColumn(column);
        square.setRow(raw);
        return square;
    }

    public Connectible setPawnPosition(Board board, Square square) {
        List<Connectible> putablePartsList = board.setPutablePartsList(square);
        int i = 0;
        int n = 0;
        Connectible connectible = new EmptyPart();
        if (putablePartsList.size() > 0 && numberOfPawns > 0) {
            System.out.println("\nType \"next\" until part where you are interested to put your pawn will be written and then type \"this\" to choose, or type \"none\" if you don't want to put any pawn");
            while (i == 0) {
                System.out.println(putablePartsList.get(n));
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                if (input.equals("this")) {
                    connectible = putablePartsList.get(n);
                    i = 9;
                } else if (input.equals("next")) {
                    if (n < putablePartsList.size() - 1) {
                        n++;
                    } else {
                        n = 0;
                    }
                } else if (input.equals("none")) {
                    i = 9;
                } else {
                    System.out.println("Wrong input. Try again.");
                }
            }
        } else {
            System.out.println("You are not able to put any pawn.");
        }
            return connectible;
    }

    public void turn(Board board, Square square) {

        square = setSquare(board, square);
        int column = square.getColumn();
        int row = square.getRow();
        try {
            board.putSquare(column, row, square);
        } catch (WrongPutException e) {
            System.out.println(e);
        }
        System.out.println(column + ":" + row + square);
        Connectible connectible = setPawnPosition(board, square);

        System.out.println(connectible);

//        if (!part.getClass().equals(EmptyPart.class)) {
//            square.putPawn(part);
//        }
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
