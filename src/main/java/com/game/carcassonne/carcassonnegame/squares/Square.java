package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.*;

public class Square implements Squares {

    private final Part up;
    private final Part left;
    private final Part right;
    private final Part down;
    private final Monastery monastery;

    public Square(Part up, Part left, Part right, Part down, Monastery monastery) {
        this.up = up;
        this.left = left;
        this.right = right;
        this.down = down;
        this.monastery = monastery;
    }

    public static Square copySquare(Square square) {
        Part up;
        Part left;
        Part down;
        Part right;

        if (square.getUp().getClass() == CitiPart.class) {
            up = new CitiPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == FieldPart.class) {
            up = new FieldPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getUp();
            up = new RoadPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {up = new EmptyPart();}

        if (square.getLeft().getClass() == CitiPart.class) {
            left = new CitiPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == FieldPart.class) {
            left = new FieldPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getLeft();
            left = new RoadPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {left = new EmptyPart();}

        if (square.getRight().getClass() == CitiPart.class) {
            right = new CitiPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == FieldPart.class) {
            right = new FieldPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getRight();
            right = new RoadPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {right = new EmptyPart();}

        if (square.getDown().getClass() == CitiPart.class) {
            down = new CitiPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == FieldPart.class) {
            down = new FieldPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getDown();
            down = new RoadPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {down = new EmptyPart();}

        Monastery monastery = new Monastery(square.isThereMonastery());

        return new Square(up, left, right, down, monastery);
    }

    public static Square copyAndTurnLeftSquare(Square square) {
        Part up;
        Part left;
        Part down;
        Part right;

        if (square.getUp().getClass() == CitiPart.class) {
            up = new CitiPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == FieldPart.class) {
            up = new FieldPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getUp();
            up = new RoadPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {up = new EmptyPart();}

        if (square.getLeft().getClass() == CitiPart.class) {
            left = new CitiPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == FieldPart.class) {
            left = new FieldPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getLeft();
            left = new RoadPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {left = new EmptyPart();}

        if (square.getRight().getClass() == CitiPart.class) {
            right = new CitiPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == FieldPart.class) {
            right = new FieldPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getRight();
            right = new RoadPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {right = new EmptyPart();}

        if (square.getDown().getClass() == CitiPart.class) {
            down = new CitiPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == FieldPart.class) {
            down = new FieldPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getDown();
            down = new RoadPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {down = new EmptyPart();}

        Monastery monastery = new Monastery(square.isThereMonastery());

        return new Square(right, up, down, left, monastery);
    }

    public static Square copyAndTurnRightSquare(Square square) {
        Part up;
        Part left;
        Part down;
        Part right;

        if (square.getUp().getClass() == CitiPart.class) {
            up = new CitiPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == FieldPart.class) {
            up = new FieldPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getUp();
            up = new RoadPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {up = new EmptyPart();}

        if (square.getLeft().getClass() == CitiPart.class) {
            left = new CitiPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == FieldPart.class) {
            left = new FieldPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getLeft();
            left = new RoadPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {left = new EmptyPart();}

        if (square.getRight().getClass() == CitiPart.class) {
            right = new CitiPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == FieldPart.class) {
            right = new FieldPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getRight();
            right = new RoadPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {right = new EmptyPart();}

        if (square.getDown().getClass() == CitiPart.class) {
            down = new CitiPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == FieldPart.class) {
            down = new FieldPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getDown();
            down = new RoadPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {down = new EmptyPart();}

        Monastery monastery = new Monastery(square.isThereMonastery());

        return new Square(left, down, up, right, monastery);
    }

    @Override
    public Part getUp() {
        return up;
    }

    @Override
    public Part getLeft() {
        return left;
    }

    @Override
    public Part getRight() {
        return right;
    }

    @Override
    public Part getDown() {
        return down;
    }

    public Monastery getMonastery() {
        return monastery;
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
