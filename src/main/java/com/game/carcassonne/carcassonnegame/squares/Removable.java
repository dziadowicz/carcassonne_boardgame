package com.game.carcassonne.carcassonnegame.squares;

public interface Removable extends Playable {

    boolean checkIfIsFinished();
    void closeAndRemovePawns();
}
