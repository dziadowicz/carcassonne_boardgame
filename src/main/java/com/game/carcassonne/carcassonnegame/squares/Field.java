package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public class Field implements Playable{

    private boolean isTherePawn = false;

    @Override
    public boolean isAvailableForPawn() {

        return false;
    }

    @Override
    public boolean getPawn() {
        return isTherePawn;
    }

    @Override
    public void putPawn(Player player) {

    }
}
