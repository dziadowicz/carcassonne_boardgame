package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.Part;

public class Square {

    private final Part side1;
    private final Part side2;
    private final Part side3;
    private final Part side4;
    private final boolean isThereMonastery;

    public Square(Part side1, Part side2, Part side3, Part side4, boolean isThereMonastery) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
        this.isThereMonastery = isThereMonastery;
    }

    public Part getSide1() {
        return side1;
    }

    public Part getSide2() {
        return side2;
    }

    public Part getSide3() {
        return side3;
    }

    public Part getSide4() {
        return side4;
    }

    public boolean isThereMonastery() {
        return isThereMonastery;
    }
}
