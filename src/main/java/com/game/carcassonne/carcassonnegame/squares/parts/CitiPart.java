package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.Citi;
import com.game.carcassonne.carcassonnegame.squares.Playable;

public class CitiPart extends Citi implements Connectible {

    private final boolean connectionToTheLeft;
    private final boolean connectionToTheRight;
    private final boolean connectionAcross;
    private final boolean shield;
    private boolean externalConnection = false;
    private int raw = 99999;
    private int column = 99999;
    private String position;
    private boolean isTherePawn = false;
    private Playable master;
    private Pawn pawn;

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
    public void setMaster(Playable playable) {
        master = playable;
    }

    @Override
    public Playable getMaster() {
        return master;
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
    public boolean isAvailableForPawn(Board board) {

        boolean result = false;

        for (Playable master : board.getMastersList()
             ) {
            if (master.getPartsList().contains(this)) {
                result = master.isAvailableForPawn(board);
            }
        }
        return result;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitiPart)) return false;

        CitiPart citiPart = (CitiPart) o;

        if (isConnectionToTheLeft() != citiPart.isConnectionToTheLeft()) return false;
        if (isConnectionToTheRight() != citiPart.isConnectionToTheRight()) return false;
        if (isConnectionAcross() != citiPart.isConnectionAcross()) return false;
        if (isShield() != citiPart.isShield()) return false;
        if (isExternalConnection() != citiPart.isExternalConnection()) return false;
        if (getRaw() != citiPart.getRaw()) return false;
        if (getColumn() != citiPart.getColumn()) return false;
        if (isTherePawn != citiPart.isTherePawn) return false;
        if (getPosition() != null ? !getPosition().equals(citiPart.getPosition()) : citiPart.getPosition() != null)
            return false;
        return getMaster() != null ? getMaster().equals(citiPart.getMaster()) : citiPart.getMaster() == null;
    }

//    @Override
//    public int hashCode() {
//        int result = (isConnectionToTheLeft() ? 1 : 0);
//        result = 31 * result + (isConnectionToTheRight() ? 1 : 0);
//        result = 31 * result + (isConnectionAcross() ? 1 : 0);
//        result = 31 * result + (isShield() ? 1 : 0);
//        result = 31 * result + (isExternalConnection() ? 1 : 0);
//        result = 31 * result + getRaw();
//        result = 31 * result + getColumn();
//        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        result = 31 * result + (getMaster() != null ? getMaster().hashCode() : 0);
//        return result;
//    }
}
