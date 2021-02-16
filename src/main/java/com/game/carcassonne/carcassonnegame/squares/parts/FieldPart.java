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
    private int row = 99999;
    private int column = 99999;
    private String position;
    private Playable master;
    private boolean isTherePawn = false;
    private Pawn pawn;
    private String pawnPosition;
    private Connectible left;
    private Connectible right;
    private Connectible across;
    private Connectible external;

    @Override
    public Connectible getLeft() {
        return left;
    }

    @Override
    public void setLeft(Connectible left) {
        this.left = left;
    }

    @Override
    public Connectible getRight() {
        return right;
    }

    @Override
    public void setRight(Connectible right) {
        this.right = right;
    }

    @Override
    public Connectible getAcross() {
        return across;
    }

    @Override
    public void setAcross(Connectible across) {
        this.across = across;
    }

    @Override
    public Connectible getExternal() {
        return external;
    }

    @Override
    public void setExternal(Connectible external) {
        this.external = external;
    }

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
    public boolean isExternalConnected() {
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
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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
    public boolean isConnectedToTheLeft() {
        return connectionToTheLeft;
    }

    @Override
    public boolean isConnectedToTheRight() {
        return connectionToTheRight;
    }

    @Override
    public boolean isConnectedAcross() {
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
                ", raw=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FieldPart)) return false;

        FieldPart fieldPart = (FieldPart) o;

        if (isConnectedToTheLeft() != fieldPart.isConnectedToTheLeft()) return false;
        if (isConnectedToTheRight() != fieldPart.isConnectedToTheRight()) return false;
        if (isConnectedAcross() != fieldPart.isConnectedAcross()) return false;
        if (isExternalConnected() != fieldPart.isExternalConnected()) return false;
        if (getRow() != fieldPart.getRow()) return false;
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
