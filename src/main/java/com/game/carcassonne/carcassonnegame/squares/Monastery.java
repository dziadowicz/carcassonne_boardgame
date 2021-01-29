package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

import java.util.ArrayList;
import java.util.List;

public class Monastery implements Removable {

    private final boolean isThereMonastery;
    private boolean isTherePawn = false;
    private List<Pawn> pawnList = new ArrayList<>();

    public Monastery(boolean isThereMonastery) {
        this.isThereMonastery = isThereMonastery;
    }

    public boolean isThereMonastery() {
        return isThereMonastery;
    }

    @Override
    public boolean isAvailableForPawn(Board board) {
        return !isTherePawn();
    }

    @Override
    public List<Pawn> getPawnList() {
        return pawnList;
    }

    @Override
    public boolean isTherePawn(){

        if (pawnList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void putPawn(Player player, Connectible connectible) {
        pawnList.add(new Pawn(player, connectible));
        connectible.putPawn(player);
    }

    @Override
    public boolean checkIfIsFinished() {
        return false;
    }

    @Override
    public void closeAndRemovePawns() {

    }

    @Override
    public List<Connectible> getPartsList() {
        return null;
    }

    @Override
    public void calculate(Connectible connectible) {

    }

    @Override
    public String toString() {
        return "isThereMonastery=" + isThereMonastery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monastery)) return false;

        Monastery monastery = (Monastery) o;

        if (isThereMonastery() != monastery.isThereMonastery()) return false;
        return isTherePawn == monastery.isTherePawn;
    }

    @Override
    public int hashCode() {
        int result = (isThereMonastery() ? 1 : 0);
        result = 31 * result + (isTherePawn ? 1 : 0);
        return result;
    }
}
