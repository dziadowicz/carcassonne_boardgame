package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public class Road implements Removable {

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
}
