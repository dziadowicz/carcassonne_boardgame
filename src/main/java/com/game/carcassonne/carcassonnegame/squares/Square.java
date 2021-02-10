package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.squares.parts.*;
import javafx.scene.image.ImageView;

public class Square implements Measurable {

    private final Connectible up;
    private final Connectible left;
    private final Connectible right;
    private final Connectible down;
    private final Monastery monastery;
    private final String mainImage;
    private int column;
    private int row;
    private ImageView imageView;

    public Square(Connectible up, Connectible left, Connectible right, Connectible down, Monastery monastery, String mainImage) {
        this.up = up;
        this.left = left;
        this.right = right;
        this.down = down;
        this.monastery = monastery;
        this.mainImage = mainImage;
        up.setPosition("Up");
        left.setPosition("Left");
        right.setPosition("Right");
        down.setPosition("Down");
        column = 99999;
        row = 99999;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        getLeft().setColumn(column);
        getRight().setColumn(column);
        getUp().setColumn(column);
        getDown().setColumn(column);

        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        getLeft().setRow(row);
        getRight().setRow(row);
        getUp().setRow(row);
        getDown().setRow(row);

        this.row = row;
    }



    @Override
    public String getMainImage() {
        return mainImage;
    }

    public static Square copySquare(Square square) {
        Connectible up;
        Connectible left;
        Connectible down;
        Connectible right;

        if (square.getUp().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getUp();
            up = new CitiPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross(), citiPart.isShield());
        } else if (square.getUp().getClass() == FieldPart.class) {
            up = new FieldPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross());
        } else if (square.getUp().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getUp();
            FieldPart leftField = new FieldPart(roadPart.getLeftField().isConnectionToTheLeft(), roadPart.getLeftField().isConnectionToTheRight(), roadPart.getLeftField().isConnectionAcross());
            FieldPart rightField = new FieldPart(roadPart.getRightField().isConnectionToTheLeft(), roadPart.getRightField().isConnectionToTheRight(), roadPart.getRightField().isConnectionAcross());
            up = new RoadPart(square.getUp().isConnectionToTheLeft(), square.getUp().isConnectionToTheRight(), square.getUp().isConnectionAcross(), leftField, rightField);
        } else {up = new EmptyPart();}

        if (square.getLeft().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getLeft();
            left = new CitiPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross(), citiPart.isShield());
        } else if (square.getLeft().getClass() == FieldPart.class) {
            left = new FieldPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross());
        } else if (square.getLeft().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getLeft();
            left = new RoadPart(square.getLeft().isConnectionToTheLeft(), square.getLeft().isConnectionToTheRight(), square.getLeft().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {left = new EmptyPart();}

        if (square.getRight().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getRight();
            right = new CitiPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross(), citiPart.isShield());
        } else if (square.getRight().getClass() == FieldPart.class) {
            right = new FieldPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross());
        } else if (square.getRight().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getRight();
            right = new RoadPart(square.getRight().isConnectionToTheLeft(), square.getRight().isConnectionToTheRight(), square.getRight().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {right = new EmptyPart();}

        if (square.getDown().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getDown();
            down = new CitiPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross(), citiPart.isShield());
        } else if (square.getDown().getClass() == FieldPart.class) {
            down = new FieldPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross());
        } else if (square.getDown().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getDown();
            down = new RoadPart(square.getDown().isConnectionToTheLeft(), square.getDown().isConnectionToTheRight(), square.getDown().isConnectionAcross(), roadPart.getLeftField(), roadPart.getRightField());
        } else {down = new EmptyPart();}

        Monastery monastery = new Monastery(square.isThereMonastery());

        String mainImage = new String(square.getMainImage());

        return new Square(up, left, right, down, monastery, mainImage);
    }

    public static Square copyAndTurnLeftSquare(Square square) {

        Square turnLeft = Square.copySquare(square);
        return new Square(turnLeft.getRight(), turnLeft.getUp(), turnLeft.getDown(), turnLeft.getLeft(), turnLeft.getMonastery(), turnLeft.getMainImage());
    }

    public static Square copyAndTurnRightSquare(Square square) {

        Square turnRight = Square.copySquare(square);
        return new Square(turnRight.getLeft(), turnRight.getDown(), turnRight.getUp(), turnRight.getRight(), turnRight.getMonastery(), turnRight.getMainImage());
    }

    @Override
    public Connectible getUp() {
        return up;
    }

    @Override
    public Connectible getLeft() {
        return left;
    }

    @Override
    public Connectible getRight() {
        return right;
    }

    @Override
    public Connectible getDown() {
        return down;
    }

    public Monastery getMonastery() {
        return monastery;
    }

    public boolean isThereMonastery() {
        return monastery.isThereMonastery();
    }

    public void addPartsToAllPartsList(Board board) {
        board.setAllPartsList(up);
        if (up.getClass().equals(RoadPart.class)) {
            RoadPart roadPart = (RoadPart) up;
            board.setAllPartsList(roadPart.getLeftField());
            board.setAllPartsList(roadPart.getRightField());
        }
        board.setAllPartsList(left);
        if (left.getClass().equals(RoadPart.class)) {
            RoadPart roadPart = (RoadPart) left;
            board.setAllPartsList(roadPart.getLeftField());
            board.setAllPartsList(roadPart.getRightField());
        }
        board.setAllPartsList(right);
        if (right.getClass().equals(RoadPart.class)) {
            RoadPart roadPart = (RoadPart) right;
            board.setAllPartsList(roadPart.getLeftField());
            board.setAllPartsList(roadPart.getRightField());
        }
        board.setAllPartsList(down);
        if (down.getClass().equals(RoadPart.class)) {
            RoadPart roadPart = (RoadPart) down;
            board.setAllPartsList(roadPart.getLeftField());
            board.setAllPartsList(roadPart.getRightField());
        }
        if (isThereMonastery()) {
            board.setMonasteryList(monastery);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (getColumn() != square.getColumn()) return false;
        if (getRow() != square.getRow()) return false;
        if (getUp() != null ? !getUp().equals(square.getUp()) : square.getUp() != null) return false;
        if (getLeft() != null ? !getLeft().equals(square.getLeft()) : square.getLeft() != null) return false;
        if (getRight() != null ? !getRight().equals(square.getRight()) : square.getRight() != null) return false;
        if (getDown() != null ? !getDown().equals(square.getDown()) : square.getDown() != null) return false;
        return getMonastery() != null ? getMonastery().equals(square.getMonastery()) : square.getMonastery() == null;
    }

    @Override
    public int hashCode() {
        int result = getUp() != null ? getUp().hashCode() : 0;
        result = 31 * result + (getLeft() != null ? getLeft().hashCode() : 0);
        result = 31 * result + (getRight() != null ? getRight().hashCode() : 0);
        result = 31 * result + (getDown() != null ? getDown().hashCode() : 0);
        result = 31 * result + (getMonastery() != null ? getMonastery().hashCode() : 0);
        result = 31 * result + getColumn();
        result = 31 * result + getRow();
        return result;
    }
}
