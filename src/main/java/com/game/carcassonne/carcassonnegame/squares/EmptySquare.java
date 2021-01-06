package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.EmptyPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

public class EmptySquare implements Squares{

    @Override
    public Part getUp() {
        return new EmptyPart();
    }

    @Override
    public Part getLeft() {
        return new EmptyPart();
    }

    @Override
    public Part getRight() {
        return new EmptyPart();
    }

    @Override
    public Part getDown() {
        return new EmptyPart();
    }

    @Override
    public String toString() {
        return "EmptySquare{}";
    }
}
