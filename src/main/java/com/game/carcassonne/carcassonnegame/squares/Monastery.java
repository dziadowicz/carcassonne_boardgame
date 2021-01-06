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
    public void checkAvailability() {

    }

    @Override
    public void putPawn(Player player) {

    }

    @Override
    public boolean chceckIfIsFinished() {
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
