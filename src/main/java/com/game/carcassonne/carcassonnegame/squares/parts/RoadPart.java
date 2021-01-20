package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.squares.Playable;
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
    private Playable master;
    private boolean isTherePawn = false;

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
    public boolean getIsTherePawn() {
        return isTherePawn;
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

        if (isConnectionToTheLeft() != roadPart.isConnectionToTheLeft()) return false;
        if (isConnectionToTheRight() != roadPart.isConnectionToTheRight()) return false;
        if (isConnectionAcross() != roadPart.isConnectionAcross()) return false;
        if (isExternalConnection() != roadPart.isExternalConnection()) return false;
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
