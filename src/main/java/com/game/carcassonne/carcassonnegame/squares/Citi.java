package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.HashSet;
import java.util.Set;

public class Citi implements Removable{

    private Set<Part> partsSet = new HashSet<>();

    @Override
    public boolean isAvailableForPawn() {

        return false;
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
}
