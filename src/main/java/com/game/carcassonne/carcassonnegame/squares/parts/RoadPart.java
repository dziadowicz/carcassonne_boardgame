package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.Playable;
import com.game.carcassonne.carcassonnegame.squares.Road;

public class RoadPart extends Road implements Connectible {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private boolean externalConnection = false;
    private int raw = 99999;
    private int column = 99999;
    private String position;
    private FieldPart leftField;
    private FieldPart rightField;
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

    public RoadPart(boolean connectionToTheLeft, boolean connectionToTheRight,
                    boolean connectionAcross, FieldPart leftField, FieldPart rightField, String pawnPosition) {
        this.connectionToTheLeft = connectionToTheLeft;
        this.connectionToTheRight = connectionToTheRight;
        this.connectionAcross = connectionAcross;
        this.leftField = leftField;
        this.rightField = rightField;
        this.pawnPosition = pawnPosition;
    }

    @Override
    public void setExternalConnection() {
        externalConnection = true;
        leftField.setExternalConnection();
        rightField.setExternalConnection();
    }

    @Override
    public String getPawnPosition() {
        return pawnPosition;
    }

    @Override
    public boolean isExternalConnected() {
        return externalConnection;
    }

    public FieldPart getLeftField() {
        return leftField;
    }

    public FieldPart getRightField() {
        return rightField;
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

        leftField.setRow(raw);
        rightField.setRow(raw);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoadPart)) return false;

        RoadPart roadPart = (RoadPart) o;

        if (isConnectedToTheLeft() != roadPart.isConnectedToTheLeft()) return false;
        if (isConnectedToTheRight() != roadPart.isConnectedToTheRight()) return false;
        if (isConnectedAcross() != roadPart.isConnectedAcross()) return false;
        if (isExternalConnected() != roadPart.isExternalConnected()) return false;
        if (getRaw() != roadPart.getRaw()) return false;
        if (getColumn() != roadPart.getColumn()) return false;
        if (isTherePawn != roadPart.isTherePawn) return false;
        if (getPosition() != null ? !getPosition().equals(roadPart.getPosition()) : roadPart.getPosition() != null)
            return false;
        if (!getLeftField().equals(roadPart.getLeftField())) return false;
        if (!getRightField().equals(roadPart.getRightField())) return false;
        return getMaster() != null ? getMaster().equals(roadPart.getMaster()) : roadPart.getMaster() == null;
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
//        result = 31 * result + getLeftField().hashCode();
//        result = 31 * result + getRightField().hashCode();
//        result = 31 * result + (getMaster() != null ? getMaster().hashCode() : 0);
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
