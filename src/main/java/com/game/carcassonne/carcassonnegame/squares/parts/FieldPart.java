package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.Field;
import com.game.carcassonne.carcassonnegame.squares.Playable;

public class FieldPart extends Field implements Connectible {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private boolean externalConnection = false;
    private int raw = 99999;
    private int column = 99999;
    private String position;
    private Playable master;
    private boolean isTherePawn = false;
    private Pawn pawn;
    private String pawnPosition;


    public FieldPart(boolean connectionToTheLeft, boolean connectionToTheRight, boolean connectionAcross, String pawnPosition) {
        this.connectionToTheLeft = connectionToTheLeft;
        this.connectionToTheRight = connectionToTheRight;
        this.connectionAcross = connectionAcross;
        this.pawnPosition = pawnPosition;
    }

    @Override
    public void setExternalConnection() {
        externalConnection = true;
    }

    @Override
    public String getPawnPosition() {
        return pawnPosition;
    }

    @Override
    public boolean isExternalConnection() {
        return externalConnection;
    }

    @Override
    public boolean getIsTherePawn() {
        return isTherePawn;
    }

    @Override
    public void putPawn(Player player) {
        isTherePawn = true;
        pawn = new Pawn(player, this);
        player.setNumberOfPawns(player.getNumberOfPawns()-1);
    }

    @Override
    public int getRaw() {
        return raw;
    }

    public void setRow(int raw) {
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
    public void setMaster(Playable playable) {
        master = playable;
    }

    @Override
    public Playable getMaster() {
        return master;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldPart)) return false;

        FieldPart fieldPart = (FieldPart) o;

        if (isConnectionToTheLeft() != fieldPart.isConnectionToTheLeft()) return false;
        if (isConnectionToTheRight() != fieldPart.isConnectionToTheRight()) return false;
        if (isConnectionAcross() != fieldPart.isConnectionAcross()) return false;
        if (isExternalConnection() != fieldPart.isExternalConnection()) return false;
        if (getRaw() != fieldPart.getRaw()) return false;
        if (getColumn() != fieldPart.getColumn()) return false;
        if (isTherePawn != fieldPart.isTherePawn) return false;
        if (getPosition() != null ? !getPosition().equals(fieldPart.getPosition()) : fieldPart.getPosition() != null)
            return false;
        return getMaster() != null ? getMaster().equals(fieldPart.getMaster()) : fieldPart.getMaster() == null;
    }

//    @Override
//    public int hashCode() {
//        int result = (isConnectionToTheLeft() ? 1 : 0);
//        result = 31 * result + (isConnectionToTheRight() ? 1 : 0);
//        result = 31 * result + (isConnectionAcross() ? 1 : 0);
//        result = 31 * result + (isExternalConnection() ? 1 : 0);
//        result = 31 * result + getRaw();
//        result = 31 * result + getColumn();
//        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
//        result = 31 * result + (getMaster() != null ? getMaster().hashCode() : 0);
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
