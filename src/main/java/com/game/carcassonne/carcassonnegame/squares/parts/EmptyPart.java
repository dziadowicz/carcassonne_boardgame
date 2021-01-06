package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.players.Player;

public class EmptyPart implements Part{
    @Override
    public void checkAvailability() {

    }

    @Override
    public void putPawn(Player player) {

    }

    @Override
    public String toString() {
        return "EmptyPart{}";
    }

}
