package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.squares.Citi;

public class CitiPart extends Citi implements Part {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private final boolean shield;
    private boolean externalConnection = false;
    private int raw = -1;
    private int column = -1;
    private String position;

    public CitiPart(boolean connectionToTheLeft, boolean connectionToTheRight, boolean connectionAcross, boolean shield) {
        this.connectionToTheLeft = connectionToTheLeft;
        this.connectionToTheRight = connectionToTheRight;
        this.connectionAcross = connectionAcross;
        this.shield = shield;
    }

    public boolean isShield() {
        return shield;
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
        return "CitiPart{" +
                "connectionToTheLeft=" + connectionToTheLeft +
                ", connectionToTheRight=" + connectionToTheRight +
                ", connectionAcross=" + connectionAcross +
                ", shield=" + shield +
                ", externalConnection=" + externalConnection +
                ", raw=" + raw +
                ", column=" + column +
                '}';
    }
}
