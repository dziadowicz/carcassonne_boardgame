package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.HashSet;
import java.util.Set;

public class Road implements Removable {

    private Set<Part> partsSet = new HashSet<>();
    private boolean isTherePawn = false;

    public Set<Part> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Part part) {
        partsSet.add(part);
    }

    @Override
    public boolean checkIfIsFinished() {
        return false;
    }

    @Override
    public void removePawn() {

    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;

        Road road = (Road) o;

        if (isTherePawn != road.isTherePawn) return false;
        return getPartsSet() != null ? getPartsSet().equals(road.getPartsSet()) : road.getPartsSet() == null;
    }

//    @Override
//    public int hashCode() {
//        int result = getPartsSet() != null ? getPartsSet().hashCode() : 0;
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
