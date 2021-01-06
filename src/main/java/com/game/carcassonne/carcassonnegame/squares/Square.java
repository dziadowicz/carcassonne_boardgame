package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.Part;

public class Square implements Squares {

    private final Part up;
    private final Part left;
    private final Part right;
    private final Part down;
    private final Monastery monastery;

    public Square(Part up, Part left, Part side3, Part down, Monastery monastery) {
        this.up = up;
        this.left = left;
        this.right = side3;
        this.down = down;
        this.monastery = monastery;
    }

    public Part getUp() {
        return up;
    }

    public Part getLeft() {
        return left;
    }

    public Part getRight() {
        return right;
    }

    public Part getDown() {
        return down;
    }

    public boolean isThereMonastery() {
        return monastery.isThereMonastery();
    }

    @Override
    public String toString() {
        return "Square{" +
                "up=" + up +
                ", left=" + left +
                ", right=" + right +
                ", down=" + down +
                ", " + monastery +
                '}';
    }
}
