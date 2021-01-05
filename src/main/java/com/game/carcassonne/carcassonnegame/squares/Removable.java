package com.game.carcassonne.carcassonnegame.squares;

public interface Removable extends Playable {

    boolean chceckIfIsFinished();
    void removePawn();
}
