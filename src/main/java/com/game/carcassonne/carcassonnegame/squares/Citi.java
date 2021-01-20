package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.HashSet;
import java.util.Set;

public class Citi implements Removable{

    private Set<Part> partsSet = new HashSet<>();

    public Set<Part> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Part part) {
        partsSet.add(part);
    }

    private boolean isTherePawn = false;

    @Override
    public boolean isAvailableForPawn() {

        return false;
    }

    @Override
    public void putPawn(Player player) {

    }

    @Override
    public boolean getPawn() {
        return isTherePawn;
    }

    @Override
    public boolean checkIfIsFinished() {
        return false;
    }

    @Override
    public void removePawn() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citi)) return false;

        Citi citi = (Citi) o;

        if (isTherePawn != citi.isTherePawn) return false;
        return getPartsSet() != null ? getPartsSet().equals(citi.getPartsSet()) : citi.getPartsSet() == null;
    }

//    @Override
//    public int hashCode() {
//        int result = getPartsSet() != null ? getPartsSet().hashCode() : 0;
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
