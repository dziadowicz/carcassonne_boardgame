package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import com.game.carcassonne.carcassonnegame.squares.parts.FieldPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;

import java.util.ArrayList;
import java.util.List;

public class SquareList {

    private List<Square> squareList00 = new ArrayList<>();

    private final Square square000 = new Square(new CitiPart(false, false, false),
            new RoadPart(false, false, true,
                    new FieldPart(false, false, true),
                    new FieldPart(false, true, true)),
            new RoadPart(false, false, true,
                    new FieldPart(true, false, true),
                    new FieldPart(false, false, true)),
            new FieldPart(true, true, false),
            new Monastery(false));

    private Square square001 = Square.copyAndTurnRightSquare(square000);
    private Square square002 = Square.copyAndTurnRightSquare(square001);
    private Square square003 = Square.copyAndTurnLeftSquare(square000);




}
