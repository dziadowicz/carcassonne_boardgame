package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.Part;

public interface Squares {

    Part getUp();
    Part getLeft();
    Part getRight();
    Part getDown();
}
