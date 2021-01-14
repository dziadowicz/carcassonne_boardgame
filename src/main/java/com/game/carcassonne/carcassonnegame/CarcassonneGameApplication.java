package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.board.WrongPutException;
import com.game.carcassonne.carcassonnegame.squares.SquareList;

public class CarcassonneGameApplication {

    public static void main(String[] args) {

        Board board = new Board();
        board.createNewBoard(11);
        System.out.println(board.getSquare(5, 5));
        try {
            System.out.println(board.putSquare(4,5, SquareList.squares().get(1)));
        } catch (WrongPutException e) {
            System.out.println("The square doesn't fit " + e);
        }
        try {
            System.out.println(board.putSquare(6,5, SquareList.squares().get(4)));
        } catch (WrongPutException e) {
            System.out.println("The square doesn't fit " + e);
        }

        System.out.println(board.getSquare(4,5));
    }


}
