package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.EmptyPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

public class EmptySquare implements Squares{

    private int column;
    private int raw;

    public EmptySquare(int column, int raw) {
        this.column = column;
        this.raw = raw;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public int getRaw() {
        return raw;
    }

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
