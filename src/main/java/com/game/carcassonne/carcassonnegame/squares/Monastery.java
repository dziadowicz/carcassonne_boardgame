package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public class Monastery implements Removable {

    private final boolean isThereMonastery;

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
}
