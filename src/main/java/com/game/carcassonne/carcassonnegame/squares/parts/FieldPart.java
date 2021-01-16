package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.squares.Field;

public class FieldPart extends Field implements Part {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private boolean externalConnection = false;
    private int raw = -1;
    private int column = -1;
    private String position;

    public FieldPart(boolean connectionToTheLeft, boolean connectionToTheRight, boolean connectionAcross) {
        this.connectionToTheLeft = connectionToTheLeft;
        this.connectionToTheRight = connectionToTheRight;
        this.connectionAcross = connectionAcross;
    }

    @Override
    public void setExternalConnection() {
        externalConnection = true;
    }

    @Override
    public boolean isExternalConnection() {
        return externalConnection;
    }

    @Override
    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setColumn(int column) {
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
        return "FieldPart{" +
                "connectionToTheLeft=" + connectionToTheLeft +
                ", connectionToTheRight=" + connectionToTheRight +
                ", connectionAcross=" + connectionAcross +
                ", externalConnection=" + externalConnection +
                ", raw=" + raw +
                ", column=" + column +
                '}';
    }
}
