package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import com.game.carcassonne.carcassonnegame.squares.parts.FieldPart;
import com.game.carcassonne.carcassonnegame.squares.parts.RoadPart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class SquareList {

    private static final Square square00 = new Square(new CitiPart(false, false, false, false, "p01.png"),
                new RoadPart(false, false, true,
                        new FieldPart(false, false, true, "p00.png"),
                        new FieldPart(false, true, true, "p06.png"),
                        "p03.png"),
                new RoadPart(false, false, true,
                        new FieldPart(true, false, true, "p06.png"),
                        new FieldPart(false, false, true, "p00.png"),
                        "p03.png"),
                new FieldPart(true, true, false, "p06.png"),
                new Monastery(false), "file:src/main/resources/squares/S_00.png");

    private static Square square01 = Square.copySquare(square00);
    private static Square square02 = Square.copySquare(square01);
    private static Square square03 = Square.copySquare(square02);

    private static Square square04 = new Square(new CitiPart(false, false, false, false, "p01.png"),
            new FieldPart(false, true, true, "p05.png"),
            new RoadPart(true, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(true, false, true, "p05.png"),
                    "p04.png"),
            new RoadPart(false, true, false,
                    new FieldPart(true, true, false, "p05.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p04.png"),
            new Monastery(false), "file:src/main/resources/squares/S_04.png");
    private static Square square05 = Square.copySquare(square04);
    private static Square square06 = Square.copySquare(square05);


    private static Square square07 = new Square(new CitiPart(false, false, false, false, "p01.png"),
            new CitiPart(false, false, false, false, "p05.png"),
            new FieldPart(true, false, false, "p03.png"),
            new FieldPart(false, true, false, "p03.png"),
            new Monastery(false), "file:src/main/resources/squares/S_07.png");
    private static Square square08 = Square.copySquare(square07);

    private static Square square09 = new Square(new CitiPart(false, false, false, false, "p01.png"),
            new RoadPart(false, true, false,
                    new FieldPart(false, true, true, "p04.png"),
                    new FieldPart(false, true, false, "p08.png"),
                    "p05.png"),
            new FieldPart(true, false, true, "p04.png"),
            new RoadPart(true, false, false,
                    new FieldPart(true, false, false, "p08.png"),
                    new FieldPart(true, true, false, "p04.png"),
                    "p05.png"),
            new Monastery(false), "file:src/main/resources/squares/S_09.png");
    private static Square square10 = Square.copySquare(square09);
    private static Square square11 = Square.copySquare(square10);

    private static Square square12 = new Square(new CitiPart(false, false, false, false, "p01.png"),
            new RoadPart(false, false, false,
                    new FieldPart(false, false, true, "p00.png"),
                    new FieldPart(false, true, false, "p08.png"),
                    "p05.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(false, false, true, "p00.png"),
                    "p04.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p08.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_12.png");
    private static Square square13 = Square.copySquare(square12);
    private static Square square14 = Square.copySquare(square13);

    private static Square square15 = new Square(new CitiPart(false, false, false, false, "p01.png"),
            new FieldPart(false, true, true, "p03.png"),
            new FieldPart(true, false, true, "p03.png"),
            new FieldPart(true, true, false, "p03.png"),
            new Monastery(false), "file:src/main/resources/squares/S_15.png");
    private static Square square16 = Square.copySquare(square15);
    private static Square square17 = Square.copySquare(square16);
    private static Square square18 = Square.copySquare(square17);
    private static Square square19 = Square.copySquare(square18);

    private static Square square20 = new Square(new FieldPart(true, true, false, "p01.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, true, "p01.png"),
                    new FieldPart(false, true, false, "p08.png"),
                    "p05.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(false, true, true, "p01.png"),
                    "p04.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p08.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_20.png");
    private static Square square21 = Square.copySquare(square20);
    private static Square square22 = Square.copySquare(square21);
    private static Square square23 = Square.copySquare(square22);

    private static Square square24 = new Square(new RoadPart(false, false, true,
                    new FieldPart(true, false, true, "p04.png"),
                    new FieldPart(false, true, true, "p05.png"),
            "p03.png"),
            new FieldPart(true, true, false, "p05.png"),
            new FieldPart(true, true, false, "p04.png"),
            new RoadPart(false, false, true,
                    new FieldPart(true, false, true, "p05.png"),
                    new FieldPart(false, true, true, "p04.png"),
                    "p03.png"),
            new Monastery(false), "file:src/main/resources/squares/S_24.png");
    private static Square square25 = Square.copySquare(square24);
    private static Square square26 = Square.copySquare(square25);
    private static Square square27 = Square.copySquare(square26);
    private static Square square28 = Square.copySquare(square27);
    private static Square square29 = Square.copySquare(square28);
    private static Square square30 = Square.copySquare(square29);
    private static Square square31 = Square.copySquare(square30);

    private static Square square32 = new Square(new FieldPart(true, true, true, "p02.png"),
            new RoadPart(false, true, false,
                    new FieldPart(true, true, true, "p02.png"),
                    new FieldPart(false, true, false, "p08.png"),
                    "p05.png"),
            new FieldPart(true, true, true, "p02.png"),
            new RoadPart(true, false, false,
                    new FieldPart(true, false, false, "p08.png"),
                    new FieldPart(true, true, true, "p02.png"),
                    "p05.png"),
            new Monastery(false), "file:src/main/resources/squares/S_32.png");
    private static Square square33 = Square.copySquare(square32);
    private static Square square34 = Square.copySquare(square33);
    private static Square square35 = Square.copySquare(square34);
    private static Square square36 = Square.copySquare(square35);
    private static Square square37 = Square.copySquare(square36);
    private static Square square38 = Square.copySquare(square37);
    private static Square square39 = Square.copySquare(square38);
    private static Square square40 = Square.copySquare(square39);

    private static Square square41 = new Square(new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p02.png"),
                    new FieldPart(false, true, false, "p00.png"),
            "p01.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p00.png"),
                    new FieldPart(false, true, false, "p08.png"),
                    "p05.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(false, true, false, "p02.png"),
                    "p04.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, false, false, "p08.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_41.png");

    private static Square square42 = new Square(new FieldPart(true, true, true, "p05.png"),
            new FieldPart(true, true, true, "p05.png"),
            new FieldPart(true, true, true, "p05.png"),
            new RoadPart(false, false, false,
                    new FieldPart(true, true, true, "p05.png"),
                    new FieldPart(true, true, true, "p05.png"),
                    "p06.png"),
            new Monastery(true), "file:src/main/resources/squares/S_42.png");
    private static Square square43 = Square.copySquare(square42);

    private static Square square44 = new Square(new FieldPart(true, true, true, "p05.png"),
            new FieldPart(true, true, true, "p05.png"),
            new FieldPart(true, true, true, "p05.png"),
            new FieldPart(true, true, true, "p05.png"),
            new Monastery(true), "file:src/main/resources/squares/S_44.png");
    private static Square square45 = Square.copySquare(square44);
    private static Square square46 = Square.copySquare(square45);
    private static Square square47 = Square.copySquare(square46);

    private static Square square48 = new Square(new CitiPart(true, true, true, true, "p03.png"),
            new CitiPart(true, true, true, false, "p03.png"),
            new CitiPart(true, true, true, false, "p03.png"),
            new CitiPart(true, true, true, false, "p03.png"),
            new Monastery(false), "file:src/main/resources/squares/S_48.png");

    private static Square square49 = new Square(new CitiPart(true, true, false, true, "p03.png"),
            new CitiPart(true, false, true, false, "p03.png"),
            new CitiPart(false, true, true, false, "p03.png"),
            new RoadPart(false, false, false,
                    new FieldPart(false, false, false, "p09.png"),
                    new FieldPart(false, false, false, "p10.png"),
                    "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_49.png");
    private static Square square50 = Square.copySquare(square49);

    private static Square square51 = new Square(new CitiPart(true, true, false, false, "p03.png"),
            new CitiPart(true, false, true, false, "p03.png"),
            new CitiPart(false, true, true, false, "p03.png"),
            new RoadPart(false, false, false,
                    new FieldPart(false, false, false, "p09.png"),
                    new FieldPart(false, false, false, "p10.png"),
                    "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_51.png");

    private static Square square52 = new Square(new CitiPart(true, true, false, true, "p03.png"),
            new CitiPart(true, false, true, false, "p03.png"),
            new CitiPart(false, true, true, false, "p03.png"),
            new FieldPart(false, false, false, "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_52.png");

    private static Square square53 = new Square(new CitiPart(true, true, false, false, "p03.png"),
            new CitiPart(true, false, true, false, "p03.png"),
            new CitiPart(false, true, true, false, "p03.png"),
            new FieldPart(false, false, false, "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_53.png");
    private static Square square54 = Square.copySquare(square53);
    private static Square square55 = Square.copySquare(square54);

    private static Square square56 = new Square(new CitiPart(false, true, false, true, "p00.png"),
            new CitiPart(true, false, false, false, "p00.png"),
            new RoadPart(true, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(true, false, false, "p02.png"),
                    "p04.png"),
            new RoadPart(false, true, false,
                    new FieldPart(false, true, false, "p02.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p04.png"),
            new Monastery(false), "file:src/main/resources/squares/S_56.png");
    private static Square square57 = Square.copySquare(square56);

    private static Square square58 = new Square(new CitiPart(false, true, false, false, "p00.png"),
            new CitiPart(true, false, false, false, "p00.png"),
            new RoadPart(true, false, false,
                    new FieldPart(true, false, false, "p07.png"),
                    new FieldPart(true, false, false, "p02.png"),
                    "p04.png"),
            new RoadPart(false, true, false,
                    new FieldPart(false, true, false, "p02.png"),
                    new FieldPart(false, true, false, "p07.png"),
                    "p04.png"),
            new Monastery(false), "file:src/main/resources/squares/S_58.png");
    private static Square square59 = Square.copySquare(square58);
    private static Square square60 = Square.copySquare(square59);

    private static Square square61 = new Square(new CitiPart(false, true, false, true, "p00.png"),
            new CitiPart(true, false, false, false, "p00.png"),
            new FieldPart(true, false, false, "p07.png"),
            new FieldPart(false, true, false, "p07.png"),
            new Monastery(false), "file:src/main/resources/squares/S_61.png");
    private static Square square62 = Square.copySquare(square61);

    private static Square square63 = new Square(new CitiPart(false, true, false, false, "p00.png"),
            new CitiPart(true, false, false, false, "p00.png"),
            new FieldPart(true, false, false, "p07.png"),
            new FieldPart(false, true, false, "p07.png"),
            new Monastery(false), "file:src/main/resources/squares/S_63.png");
    private static Square square64 = Square.copySquare(square63);
    private static Square square65 = Square.copySquare(square64);

    private static Square square66 = new Square(new FieldPart(false, false, false, "p01.png"),
            new CitiPart(false, false, true, false, "p03.png"),
            new CitiPart(false, false, true, true, "p03.png"),
            new FieldPart(false, false, false, "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_66.png");
    private static Square square67 = Square.copySquare(square66);

    private static Square square68 = new Square(new FieldPart(false, false, false, "p01.png"),
            new CitiPart(false, false, true, false, "p03.png"),
            new CitiPart(false, false, true, false, "p03.png"),
            new FieldPart(false, false, false, "p06.png"),
            new Monastery(false), "file:src/main/resources/squares/S_68.png");

    private static Square square69 = new Square(new FieldPart(false, false, true, "p03.png"),
            new CitiPart(false, false, false, false, "p05.png"),
            new CitiPart(false, false, false, false, "p04.png"),
            new FieldPart(false, false, true, "p03.png"),
            new Monastery(false), "file:src/main/resources/squares/S_69.png");
    private static Square square70 = Square.copySquare(square69);
    private static Square square71 = Square.copySquare(square70);



    public static List<Square> getSquares() {
        List<Square> squareList = new ArrayList<>();
        squareList.add(Square.copySquare(square00));
        squareList.add(square01);
        squareList.add(square02);
        squareList.add(square03);
        squareList.add(square04);
        squareList.add(square05);
        squareList.add(square06);
        squareList.add(square07);
        squareList.add(square08);
        squareList.add(square09);
        squareList.add(square10);
        squareList.add(square11);
        squareList.add(square12);
        squareList.add(square13);
        squareList.add(square14);
        squareList.add(square15);
        squareList.add(square16);
        squareList.add(square17);
        squareList.add(square18);
        squareList.add(square19);
        squareList.add(square20);
        squareList.add(square21);
        squareList.add(square22);
        squareList.add(square23);
        squareList.add(square24);
        squareList.add(square25);
        squareList.add(square26);
        squareList.add(square27);
        squareList.add(square28);
        squareList.add(square29);
        squareList.add(square30);
        squareList.add(square31);
        squareList.add(square32);
        squareList.add(square33);
        squareList.add(square34);
        squareList.add(square35);
        squareList.add(square36);
        squareList.add(square37);
        squareList.add(square38);
        squareList.add(square39);
        squareList.add(square40);
        squareList.add(square41);
        squareList.add(square42);
        squareList.add(square43);
        squareList.add(square44);
        squareList.add(square45);
        squareList.add(square46);
        squareList.add(square47);
        squareList.add(square48);
        squareList.add(square49);
        squareList.add(square50);
        squareList.add(square51);
        squareList.add(square52);
        squareList.add(square53);
        squareList.add(square54);
        squareList.add(square55);
        squareList.add(square56);
        squareList.add(square57);
        squareList.add(square58);
        squareList.add(square59);
        squareList.add(square60);
        squareList.add(square61);
        squareList.add(square62);
        squareList.add(square63);
        squareList.add(square64);
        squareList.add(square65);
        squareList.add(square66);
        squareList.add(square67);
        squareList.add(square68);
        squareList.add(square69);
        squareList.add(square70);
        squareList.add(square71);

        for (Square square: squareList
             ) {
            square.setConnections();
        }

        return squareList;
    }

    public static Deque<Square> shuffledSquareDeque() {

        Deque<Square> gameSquaresDeque = new ArrayDeque<>();

        List<Square> shuffledList = SquareList.getSquares();
        Collections.shuffle(shuffledList);

        for (Square square: shuffledList) {
            gameSquaresDeque.push(square);
        }

        return gameSquaresDeque;
    }

    public static Square getStartingSquare() {
        return square00;
    }
}
