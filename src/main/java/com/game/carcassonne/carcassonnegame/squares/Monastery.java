package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.HashSet;
import java.util.Set;

public class Monastery implements Removable {

    private final boolean isThereMonastery;
    private boolean isTherePawn = false;

    public Monastery(boolean isThereMonastery) {
        this.isThereMonastery = isThereMonastery;
    }

    public boolean isThereMonastery() {
        return isThereMonastery;
    }

    @Override
    public boolean isAvailableForPawn() {

        return true;
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
