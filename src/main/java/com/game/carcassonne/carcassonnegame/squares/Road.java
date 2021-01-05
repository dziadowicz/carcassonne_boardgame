package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public class Road implements Removable {

    @Override
    public boolean chceckIfIsFinished() {
        return false;
    }

    @Override
    public void removePawn() {

    }

    @Override
    public void checkAvailability() {

    }

    @Override
    public void putPawn(Player player) {

    }
}
