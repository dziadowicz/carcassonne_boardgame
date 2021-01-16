package com.game.carcassonne.carcassonnegame.board;

import com.game.carcassonne.carcassonnegame.squares.*;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import com.game.carcassonne.carcassonnegame.squares.parts.FieldPart;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Squares>> columnList = new ArrayList<>();
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        createNewBoard();
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<List<Squares>> getColumnList() {
        return columnList;
    }

    public void createNewBoard() {

        for (int i = 0; i < boardSize; i++) {
            columnList.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                columnList.get(i).add(new EmptySquare(j, i));
            }
        }
        columnList.get(boardSize/2).set(boardSize/2, SquareList.getStartingSquare());
        SquareList.getStartingSquare().setColumn(boardSize/2);
        SquareList.getStartingSquare().setRaw(boardSize/2);
    }

    public boolean doesItFit(int column, int raw, Squares square) {
        if (column != 0 && column != (boardSize-1) && raw != 0 && raw != (boardSize-1)) {
            boolean isAvailable = columnList.get(raw).get(column).getClass().equals(EmptySquare.class);
            boolean isConnected = !(columnList.get(raw + 1).get(column).getClass().equals(EmptySquare.class) &&
                    columnList.get(raw - 1).get(column).getClass().equals(EmptySquare.class) &&
                    columnList.get(raw).get(column + 1).getClass().equals(EmptySquare.class) &&
                    columnList.get(raw).get(column - 1).getClass().equals(EmptySquare.class));
            boolean fitsLeft = columnList.get(raw).get(column - 1).getRight().getClass().equals(square.getLeft().getClass()) ||
                    columnList.get(raw).get(column - 1).getClass().equals(EmptySquare.class);
            boolean fitsRight = columnList.get(raw).get(column + 1).getLeft().getClass().equals(square.getRight().getClass()) ||
                    columnList.get(raw).get(column + 1).getClass().equals(EmptySquare.class);
            boolean fitsUp = columnList.get(raw + 1).get(column).getDown().getClass().equals(square.getUp().getClass()) ||
                    columnList.get(raw + 1).get(column).getClass().equals(EmptySquare.class);
            boolean fitsDown = columnList.get(raw - 1).get(column).getUp().getClass().equals(square.getDown().getClass()) ||
                    columnList.get(raw - 1).get(column).getClass().equals(EmptySquare.class);

            if (isAvailable && isConnected && fitsLeft && fitsRight && fitsUp && fitsDown) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean putSquare(int column, int raw, Square square) {// throws WrongPutException {


        if (doesItFit(column, raw, square)) {
            columnList.get(raw).set(column, square);
            square.setRaw(raw);
            square.setColumn(column);
            return true;
        } else {
            return false;
            //throw new WrongPutException();
        }
    }

    public String getSquareToString(int column, int raw) {
        return columnList.get(raw).get(column).toString();
    }

    public Squares getSquare(int column, int raw) {
        return columnList.get(raw).get(column);
    }

}
