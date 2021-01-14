package com.game.carcassonne.carcassonnegame.board;

import com.game.carcassonne.carcassonnegame.squares.*;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import com.game.carcassonne.carcassonnegame.squares.parts.FieldPart;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Squares>> columnList = new ArrayList<>();
/*    private final Square startingSquare = new Square(new CitiPart(false, false, false),
            new RoadPart(false, false, true,
                    new FieldPart(false, false, true),
                    new FieldPart(false, true, true)),
            new RoadPart(false, false, true,
                    new FieldPart(true, false, true),
                    new FieldPart(false, false, true)),
            new FieldPart(true, true, false),
            new Monastery(false));*/

    public void createNewBoard(int boardSize) {

        for (int i = 0; i < boardSize; i++) {
            columnList.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                columnList.get(i).add(new EmptySquare());
            }
        }

        columnList.get(boardSize/2).set(boardSize/2, SquareList.getStartingSquare());

    }

    public boolean putSquare(int column, int raw, Square square) throws WrongPutException {
        boolean isAvailable = columnList.get(raw).get(column).getClass().equals(EmptySquare.class);
        boolean isConnected = !(columnList.get(raw+1).get(column).getClass().equals(EmptySquare.class) &&
                columnList.get(raw-1).get(column).getClass().equals(EmptySquare.class) &&
                columnList.get(raw).get(column+1).getClass().equals(EmptySquare.class) &&
                columnList.get(raw).get(column-1).getClass().equals(EmptySquare.class));
        boolean fitsLeft = columnList.get(raw).get(column-1).getRight().getClass().equals(square.getLeft().getClass()) ||
                columnList.get(raw).get(column-1).getClass().equals(EmptySquare.class);
        boolean fitsRight = columnList.get(raw).get(column+1).getLeft().getClass().equals(square.getRight().getClass()) ||
                columnList.get(raw).get(column+1).getClass().equals(EmptySquare.class);
        boolean fitsUp = columnList.get(raw+1).get(column).getDown().getClass().equals(square.getUp().getClass()) ||
                columnList.get(raw+1).get(column).getClass().equals(EmptySquare.class);
        boolean fitsDown = columnList.get(raw-1).get(column).getUp().getClass().equals(square.getDown().getClass()) ||
                columnList.get(raw-1).get(column).getClass().equals(EmptySquare.class);

        if (isAvailable && isConnected && fitsLeft && fitsRight && fitsUp && fitsDown) {
            columnList.get(raw).set(column, square);
            return true;
        } else {
            throw new WrongPutException();
        }
    }

    public String getSquare(int column, int raw) {
        return columnList.get(raw).get(column).toString();
    }

}
