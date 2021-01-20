package com.game.carcassonne.carcassonnegame.board;

import com.game.carcassonne.carcassonnegame.squares.*;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;

import java.util.*;

public class Board {

    private List<List<Squares>> columnList = new ArrayList<>();
    private int boardSize;
    private List<Squares> availableSquaresList = new ArrayList<>();
    List<Set<Playable>> mastersList = new ArrayList<>();
    Set<Playable> citiSet = new HashSet<>();
    Set<Playable> fieldSet = new HashSet<>();
    Set<Playable> monasterySet = new HashSet<>();
    Set<Playable> roadSet = new HashSet<>();

    public Board(int boardSize) {
        this.boardSize = boardSize;
        createNewBoard();
    }

    public void setAvailableSquaresList(Square square){

        availableSquaresList.clear();

        for (int raw = 0; raw < getBoardSize(); raw++) {
            for (int column = 0; column < getBoardSize(); column++) {
                if (doesItFit(column, raw, square)) {
                    availableSquaresList.add(getSquare(column, raw));
                }
            }
        }
    }

    public boolean isThereAnyPossibleMove(Square square) {
        availableSquaresList.clear();

        setAvailableSquaresList(square);
        setAvailableSquaresList(Square.copyAndTurnRightSquare(square));
        setAvailableSquaresList(Square.copyAndTurnRightSquare(Square.copyAndTurnRightSquare(square)));
        setAvailableSquaresList(Square.copyAndTurnLeftSquare(square));

        if (availableSquaresList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean putSquareRandomly(Square square) {

        availableSquaresList.clear();
        setAvailableSquaresList(square);
        if (availableSquaresList.size() > 0) {
            Squares availableEmptySquare = availableSquaresList.get(new Random().nextInt(availableSquaresList.size()));
            try {
                square.setColumn(availableEmptySquare.getColumn());
                square.setRaw(availableEmptySquare.getRaw());
                putSquare(availableEmptySquare.getColumn(), availableEmptySquare.getRaw(), square);
            } catch (WrongPutException e) {
                System.out.println("Wrong put: " + e);
            }
            return true;
        } else {return false;}
    }

    public List<Squares> getAvailableSquaresList() {
        return availableSquaresList;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<List<Squares>> getColumnList() {
        return columnList;
    }

    public void createNewBoard() {

        mastersList.add(citiSet);
        mastersList.add(fieldSet);
        mastersList.add(monasterySet);
        mastersList.add(roadSet);

        for (int i = 0; i < boardSize; i++) {
            columnList.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                columnList.get(i).add(new EmptySquare(j, i));
            }
        }
        Square square = SquareList.getStartingSquare();
        columnList.get(boardSize/2).set(boardSize/2, square);
        square.setColumn(boardSize/2);
        square.setRaw(boardSize/2);

        Citi citi = new Citi();
        square.getUp().setMaster(citi);
        citi.setPartsSet(square.getUp());
        citiSet.add(citi);

        Road road = new Road();
        square.getLeft().setMaster(road);
        square.getRight().setMaster(road);
        road.setPartsSet(square.getLeft());
        road.setPartsSet(square.getRight());
        roadSet.add(road);

        Field field1 = new Field();
        RoadPart roadPart1 = (RoadPart) square.getLeft();
        RoadPart roadPart2 = (RoadPart) square.getRight();
        roadPart1.getLeftField().setMaster(field1);
        roadPart2.getRightField().setMaster(field1);
        field1.setPartsSet(roadPart1.getLeftField());
        field1.setPartsSet(roadPart2.getRightField());

        Field field2 = new Field();
        roadPart1.getRightField().setMaster(field2);
        roadPart2.getLeftField().setMaster(field2);
        square.getDown().setMaster(field2);
        field2.setPartsSet(roadPart1.getRightField());
        field2.setPartsSet(roadPart2.getLeftField());
        field2.setPartsSet(square.getDown());
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

    public boolean putSquare(int column, int raw, Square square) throws WrongPutException {

        if (doesItFit(column, raw, square)) {
            columnList.get(raw).set(column, square);
            square.setRaw(raw);
            square.setColumn(column);
            if (columnList.get(raw).get(column - 1).getRight().getClass().equals(square.getLeft().getClass())) {
                square.getLeft().setExternalConnection();
                columnList.get(raw).get(column - 1).getRight().setExternalConnection();
            }
            if (columnList.get(raw).get(column + 1).getLeft().getClass().equals(square.getRight().getClass())){
                square.getRight().setExternalConnection();
                columnList.get(raw).get(column + 1).getLeft().setExternalConnection();
            }
            if (columnList.get(raw + 1).get(column).getDown().getClass().equals(square.getUp().getClass())) {
                square.getUp().setExternalConnection();
                columnList.get(raw + 1).get(column).getDown().setExternalConnection();
            }
            if (columnList.get(raw - 1).get(column).getUp().getClass().equals(square.getDown().getClass())) {
                square.getDown().setExternalConnection();
                columnList.get(raw - 1).get(column).getUp().setExternalConnection();
            }
            return true;
        } else {
            throw new WrongPutException();
        }
    }

    public void showAvailableSquares(Square square) {

    setAvailableSquaresList(square);

        System.out.println("The square can be located in: ");

        for (Squares squares: availableSquaresList) {
            System.out.print(squares.getColumn() + ":" + squares.getRaw() + " | ");
        }
    }

    public List<Part> setPutablePartsList(Square square) {

        List<Part> putablePartsList = new ArrayList<>();

        if (!columnList.get(square.getRaw()).get(square.getColumn() + 1).getClass().equals(EmptySquare.class)) {
            if (square.getRight().isAvailableForPawn()) {
                putablePartsList.add(square.getRight());
            }
            if (square.getRight().getClass().equals(RoadPart.class)) {
                RoadPart roadPart= (RoadPart)square.getRight();
                if (roadPart.getLeftField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getLeftField());
                }
                if (roadPart.getRightField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getRightField());
                }
            }
        }

        if (!columnList.get(square.getRaw() + 1).get(square.getColumn()).getClass().equals(EmptySquare.class)) {
            if (square.getUp().isAvailableForPawn()) {
                putablePartsList.add(square.getUp());
            }
            if (square.getUp().getClass().equals(RoadPart.class)) {
                RoadPart roadPart= (RoadPart)square.getUp();
                if (roadPart.getLeftField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getLeftField());
                }
                if (roadPart.getRightField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getRightField());
                }
            }
        }

        if (!columnList.get(square.getRaw() - 1).get(square.getColumn()).getClass().equals(EmptySquare.class)) {
            if (square.getDown().isAvailableForPawn()) {
                putablePartsList.add(square.getDown());
            }
            if (square.getDown().getClass().equals(RoadPart.class)) {
                RoadPart roadPart= (RoadPart)square.getDown();
                if (roadPart.getLeftField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getLeftField());
                }
                if (roadPart.getRightField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getRightField());
                }
            }
        }

        if (!columnList.get(square.getRaw()).get(square.getColumn() - 1).getClass().equals(EmptySquare.class)) {
            if (square.getLeft().isAvailableForPawn()) {
                putablePartsList.add(square.getLeft());
            }
            if (square.getLeft().getClass().equals(RoadPart.class)) {
                RoadPart roadPart= (RoadPart)square.getLeft();
                if (roadPart.getLeftField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getLeftField());
                }
                if (roadPart.getRightField().isAvailableForPawn()) {
                    putablePartsList.add(roadPart.getRightField());
                }
            }
        }

        return putablePartsList;
    }

    public String getSquareToString(int column, int raw) {
        return columnList.get(raw).get(column).toString();
    }

    public Squares getSquare(int column, int raw) {
        return columnList.get(raw).get(column);
    }
}
