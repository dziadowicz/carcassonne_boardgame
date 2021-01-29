package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.EmptyPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

public class EmptySquare implements Measurable {

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
    public Connectible getUp() {
        return new EmptyPart();
    }

    @Override
    public Connectible getLeft() {
        return new EmptyPart();
    }

    @Override
    public Connectible getRight() {
        return new EmptyPart();
    }

    @Override
    public Connectible getDown() {
        return new EmptyPart();
    }

    @Override
    public String toString() {
        return "EmptySquare{}";
    }
}
