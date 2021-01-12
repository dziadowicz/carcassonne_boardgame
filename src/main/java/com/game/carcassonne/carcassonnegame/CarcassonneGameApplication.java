package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.board.WrongPutException;
import com.game.carcassonne.carcassonnegame.squares.Monastery;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.parts.FieldPart;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;

public class CarcassonneGameApplication {

    public static void main(String[] args) {

        Board board = new Board();
        board.createNewBoard(11);
        System.out.println(board.getSquare(5, 5));
        try {
            System.out.println(board.putSquare(4,5,
                    new Square(new RoadPart(false, false, false,
                                    new FieldPart(true, false, false),
                                    new FieldPart(false, true, false)),
                            new RoadPart(false, false, false,
                                    new FieldPart(true, false, false),
                                    new FieldPart(false, true, true)),
                            new RoadPart(false, false, false,
                                    new FieldPart(true, false, false),
                                    new FieldPart(false, true, false)),
                            new RoadPart(),
                            new Monastery(false))));
        } catch (WrongPutException e) {
            System.out.println("The square doesn't fit " + e);
        }
        try {
            System.out.println(board.putSquare(4,5,
                    new Square(new RoadPart(), new RoadPart(), new RoadPart(),
                            new RoadPart(), new Monastery(false),
                            false, false, false,
                            false, false, false)));
        } catch (WrongPutException e) {
            System.out.println("The square doesn't fit " + e);
        }

        System.out.println(board.getSquare(4,5));
    }


}
