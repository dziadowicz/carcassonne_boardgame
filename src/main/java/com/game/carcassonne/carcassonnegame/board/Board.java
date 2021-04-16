package com.game.carcassonne.carcassonnegame.board;

import com.game.carcassonne.carcassonnegame.squares.*;
import com.game.carcassonne.carcassonnegame.squares.parts.*;

import java.util.*;

public class Board {

    private List<List<Measurable>> columnList = new ArrayList<>();
    private int boardSize;
    private List<Measurable> availableSquaresList = new ArrayList<>();
    private List<Connectible> allPartsList = new ArrayList<>();
    List<Playable> mastersList = new ArrayList<>();
    List<Monastery> monasteryList = new ArrayList<>();

    public Board(int boardSize) {
        this.boardSize = boardSize;
        createNewBoard();
    }

    public void setAvailableSquaresList(Square square){

        availableSquaresList.clear();

        for (int row = 0; row < getBoardSize(); row++) {
            for (int column = 0; column < getBoardSize(); column++) {
                if (doesItFit(column, row, square)) {
                    availableSquaresList.add(getSquare(column, row));
                }
            }
        }
    }

    public List<Monastery> getMonasteryList() {
        return monasteryList;
    }

    public void setMonasteryList(Monastery monastery) {
        monasteryList.add(monastery);
    }


    public void setMastersList() {
        mastersList.clear();
        setAllPartsList();

        for (Connectible connectible : allPartsList) {
            boolean check = false;
            for (Playable master : mastersList) {
                if (master.getPartsList().contains(connectible)) {
                    check = true;
                }
                if (!check) {
                    if (connectible.getClass().equals(CitiPart.class)) {
                        Citi citi = new Citi();
                        citi.calculate(connectible);
                        mastersList.add(citi);
                    }
                    if (connectible.getClass().equals(FieldPart.class)) {
                        Field field = new Field();
                        field.calculate(connectible);
                        mastersList.add(field);
                    }
                    if (connectible.getClass().equals(RoadPart.class)) {
                        Road road = new Road();
                        road.calculate(connectible);
                        mastersList.add(new Road());

                    }
                }
            }
        }

        for (Monastery monastery : monasteryList
             ) {
            int n = 0;
            for (int row = monastery.getRow() - 1; row < monastery.getRow() + 2; row++) {
                for (int column = monastery.getColumn() - 1; column < monastery.getColumn() + 2; column++) {
                    if (getSquare(column, row).getClass().equals(Square.class)) n++;
                }
            }
            monastery.setNeighbours(n);
            mastersList.add(monastery);
        }
    }

    public List<Playable> getMastersList() {
        setMastersList();
        return mastersList;
    }

    public void calculate() {
       setMastersList();
        for (Playable master : mastersList) {
            if (master instanceof Removable) {
                if (((Removable) master).checkIfIsFinished() && master.isTherePawn()) {
                    ((Removable) master).closeAndRemovePawns();
                }
            }
        }
    }

    public List<Connectible> getAllPartsList() {

        setAllPartsList();
        return allPartsList;
    }

    public void setAllPartsList() {
        allPartsList.clear();
        for (int row = 0; row < getBoardSize(); row++) {
            for (int column = 0; column < getBoardSize(); column++) {
                if (getSquare(column, row).getClass().equals(Square.class)) {
                    allPartsList.add(getSquare(column, row).getUp());
                    if (getSquare(column, row).getUp().getClass().equals(RoadPart.class)) {
                        allPartsList.add(((RoadPart)getSquare(column, row).getUp()).getRightField());
                        allPartsList.add(((RoadPart)getSquare(column, row).getUp()).getLeftField());
                    }
                    allPartsList.add(getSquare(column, row).getLeft());
                    if (getSquare(column, row).getLeft().getClass().equals(RoadPart.class)) {
                        allPartsList.add(((RoadPart)getSquare(column, row).getLeft()).getRightField());
                        allPartsList.add(((RoadPart)getSquare(column, row).getLeft()).getLeftField());
                    }
                    allPartsList.add(getSquare(column, row).getRight());
                    if (getSquare(column, row).getRight().getClass().equals(RoadPart.class)) {
                        allPartsList.add(((RoadPart)getSquare(column, row).getRight()).getRightField());
                        allPartsList.add(((RoadPart)getSquare(column, row).getRight()).getLeftField());
                    }
                    allPartsList.add(getSquare(column, row).getDown());
                    if (getSquare(column, row).getDown().getClass().equals(RoadPart.class)) {
                        allPartsList.add(((RoadPart)getSquare(column, row).getDown()).getRightField());
                        allPartsList.add(((RoadPart)getSquare(column, row).getDown()).getLeftField());
                    }
                    if (((Square)getSquare(column, row)).isThereMonastery()) monasteryList.add(((Square)getSquare(column, row)).getMonastery());
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
            Measurable availableEmptySquare = availableSquaresList.get(new Random().nextInt(availableSquaresList.size()));
            try {
                square.setColumn(availableEmptySquare.getColumn());
                square.setRow(availableEmptySquare.getRow());
                putSquare(availableEmptySquare.getColumn(), availableEmptySquare.getRow(), square);
            } catch (WrongPutException e) {
                System.out.println("Wrong put: " + e);
            }
            return true;
        } else return false;
    }

    public List<Measurable> getAvailableSquaresList() {
        return availableSquaresList;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<List<Measurable>> getColumnList() {
        return columnList;
    }

    public void createNewBoard() {

        for (int i = 0; i < boardSize; i++) {
            columnList.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                columnList.get(i).add(new EmptySquare(j, i));
            }
        }
        Square square = SquareList.getStartingSquare();
        columnList.get(boardSize/2).set(boardSize/2, square);
        square.setColumn(boardSize/2);
        square.setRow(boardSize/2);

        Citi citi = new Citi();
        square.getUp().setMaster(citi);
        citi.setPartsList(square.getUp());

        Road road = new Road();
        square.getLeft().setMaster(road);
        square.getRight().setMaster(road);

        Field field1 = new Field();
        RoadPart roadPart1 = (RoadPart) square.getLeft();
        RoadPart roadPart2 = (RoadPart) square.getRight();
        roadPart1.getLeftField().setMaster(field1);
        roadPart2.getRightField().setMaster(field1);

        Field field2 = new Field();
        roadPart1.getRightField().setMaster(field2);
        roadPart2.getLeftField().setMaster(field2);
        square.getDown().setMaster(field2);
    }

    public boolean doesItFit(int column, int row, Measurable square) {
        if (column != 0 && column != (boardSize-1) && row != 0 && row != (boardSize-1)) {
            boolean isAvailable = columnList.get(row).get(column).getClass().equals(EmptySquare.class);
            boolean isConnected = !(columnList.get(row + 1).get(column).getClass().equals(EmptySquare.class) &&
                    columnList.get(row - 1).get(column).getClass().equals(EmptySquare.class) &&
                    columnList.get(row).get(column + 1).getClass().equals(EmptySquare.class) &&
                    columnList.get(row).get(column - 1).getClass().equals(EmptySquare.class));
            boolean fitsLeft = columnList.get(row).get(column - 1).getRight().getClass().equals(square.getLeft().getClass()) ||
                    columnList.get(row).get(column - 1).getClass().equals(EmptySquare.class);
            boolean fitsRight = columnList.get(row).get(column + 1).getLeft().getClass().equals(square.getRight().getClass()) ||
                    columnList.get(row).get(column + 1).getClass().equals(EmptySquare.class);
            boolean fitsUp = columnList.get(row -1).get(column).getDown().getClass().equals(square.getUp().getClass()) ||
                    columnList.get(row - 1).get(column).getClass().equals(EmptySquare.class);
            boolean fitsDown = columnList.get(row + 1).get(column).getUp().getClass().equals(square.getDown().getClass()) ||
                    columnList.get(row + 1).get(column).getClass().equals(EmptySquare.class);

            if (isAvailable && isConnected && fitsLeft && fitsRight && fitsUp && fitsDown) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean putSquare(int column, int row, Square square) throws WrongPutException {

        if (doesItFit(column, row, square)) {
            columnList.get(row).set(column, square);
            square.setRow(row);
            square.setColumn(column);
            if (columnList.get(row).get(column - 1).getRight().getClass().equals(square.getLeft().getClass())) {
                square.getLeft().setExternalConnection();
                columnList.get(row).get(column - 1).getRight().setExternalConnection();
            }
            if (columnList.get(row).get(column + 1).getLeft().getClass().equals(square.getRight().getClass())){
                square.getRight().setExternalConnection();
                columnList.get(row).get(column + 1).getLeft().setExternalConnection();
            }
            if (columnList.get(row + 1).get(column).getDown().getClass().equals(square.getUp().getClass())) {
                square.getUp().setExternalConnection();
                columnList.get(row + 1).get(column).getDown().setExternalConnection();
            }
            if (columnList.get(row - 1).get(column).getUp().getClass().equals(square.getDown().getClass())) {
                square.getDown().setExternalConnection();
                columnList.get(row - 1).get(column).getUp().setExternalConnection();
            }
            return true;
        } else {
            throw new WrongPutException();
        }
    }

    public void showAvailableSquares(Square square) {

    setAvailableSquaresList(square);

        System.out.println("The square can be located in: ");

        for (Measurable measurable : availableSquaresList) {
            System.out.print(measurable.getColumn() + ":" + measurable.getRow() + " | ");
        }
    }

    public List<Connectible> setPutablePartsList(Square square) {

        List<Connectible> putablePartsList = new ArrayList<>();

        if (!columnList.get(square.getRow()).get(square.getColumn() + 1).getClass().equals(EmptySquare.class)) {
            addAllConnectedFields(putablePartsList, square.getRight());
        }

        if (!columnList.get(square.getRow() + 1).get(square.getColumn()).getClass().equals(EmptySquare.class)) {
            addAllConnectedFields(putablePartsList, square.getUp());
        }

        if (!columnList.get(square.getRow() - 1).get(square.getColumn()).getClass().equals(EmptySquare.class)) {
            addAllConnectedFields(putablePartsList, square.getDown());
        }

        if (!columnList.get(square.getRow()).get(square.getColumn() - 1).getClass().equals(EmptySquare.class)) {
            addAllConnectedFields(putablePartsList, square.getLeft());
        }

        return putablePartsList;
    }

    private void addAllConnectedFields(List<Connectible> putablePartsList, Connectible down) {
        addConnectedField(putablePartsList, down);
        if (down instanceof RoadPart) {
            RoadPart roadPart = (RoadPart) down;
            addConnectedField(putablePartsList, roadPart.getLeftField());
            addConnectedField(putablePartsList, roadPart.getRightField());
        }
    }

    private void addConnectedField(List<Connectible> putablePartsList, Connectible leftField) {
        if (leftField.isAvailableForPawn(this)) {
            putablePartsList.add(leftField);
        }
    }

    public String getSquareToString(int column, int row) {
        return columnList.get(row).get(column).toString();
    }

    public Measurable getSquare(int column, int row) {
        return columnList.get(row).get(column);
    }
}
