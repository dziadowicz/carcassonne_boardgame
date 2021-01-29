package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

public interface Measurable {

    Connectible getUp();
    Connectible getLeft();
    Connectible getRight();
    Connectible getDown();
    int getColumn();
    int getRaw();
}
