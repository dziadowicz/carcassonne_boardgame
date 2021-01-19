package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.squares.Road;

public class RoadPart extends Road implements Part {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private boolean externalConnection = false;
    private int raw = 99999;
    private int column = 99999;
    private String position;
    private FieldPart leftField;
    private FieldPart rightField;

    public RoadPart(boolean connectionToTheLeft, boolean connectionToTheRight,
                    boolean connectionAcross, FieldPart leftField, FieldPart rightField) {
        this.connectionToTheLeft = connectionToTheLeft;
        this.connectionToTheRight = connectionToTheRight;
        this.connectionAcross = connectionAcross;
        this.leftField = leftField;
        this.rightField = rightField;
    }

    @Override
    public void setExternalConnection() {
        externalConnection = true;
        leftField.setExternalConnection();
        rightField.setExternalConnection();
    }

    @Override
    public boolean isExternalConnection() {
        return externalConnection;
    }

    public FieldPart getLeftField() {
        return leftField;
    }

    public FieldPart getRightField() {
        return rightField;
    }

    @Override
    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {

        leftField.setRaw(raw);
        rightField.setRaw(raw);
        this.raw = raw;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setColumn(int column) {

        leftField.setColumn(column);
        rightField.setColumn(column);
        this.column = column;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public boolean isConnectionToTheLeft() {
        return connectionToTheLeft;
    }

    @Override
    public boolean isConnectionToTheRight() {
        return connectionToTheRight;
    }

    @Override
    public boolean isConnectionAcross() {
        return connectionAcross;
    }

    @Override
    public String toString() {
        return "RoadPart{" +
                "connectionToTheLeft=" + connectionToTheLeft +
                ", connectionToTheRight=" + connectionToTheRight +
                ", connectionAcross=" + connectionAcross +
                ", externalConnection=" + externalConnection +
                ", raw=" + raw +
                ", column=" + column +
                ", leftField=" + leftField +
                ", rightField=" + rightField +
                '}';
    }
}
