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
    private int rotation;

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
        rotation = 0;
    }

    public Square(Connectible up, Connectible left, Connectible right, Connectible down, Monastery monastery, String mainImage, int rotation) {
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
        this.rotation = rotation;
    }

    void setConnections() {
        if (up.isConnectedToTheLeft() && right.isConnectedToTheRight()) {
            up.setLeft(right);
            right.setRight(up);
        }
        if (up.isConnectedToTheRight() && left.isConnectedToTheLeft()) {
            up.setRight(left);
            left.setLeft(up);
        }
        if (up.isConnectedAcross() && down.isConnectedAcross()) {
            up.setAcross(down);
            down.setAcross(up);
        }
        if (left.isConnectedToTheRight() && down.isConnectedToTheLeft()) {
            left.setRight(down);
            down.setLeft(left);
        }
        if (left.isConnectedAcross() && right.isConnectedAcross()) {
            left.setAcross(right);
            right.setAcross(left);
        }
        if (right.isConnectedToTheLeft() && down.isConnectedToTheRight()) {
            right.setLeft(down);
            down.setRight(right);
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(RoadPart.class) && !up.getClass().equals(RoadPart.class) && down.getClass().equals(FieldPart.class)) {
            ((RoadPart) left).getLeftField().setAcross(((RoadPart) right).getRightField());
            ((RoadPart) left).getRightField().setAcross(((RoadPart) right).getLeftField());
            ((RoadPart) left).getRightField().setRight(down);
            ((RoadPart) right).getLeftField().setAcross(((RoadPart) left).getRightField());
            ((RoadPart) right).getRightField().setAcross(((RoadPart) left).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(down);
            down.setLeft(((RoadPart) left).getRightField());
            down.setRight(((RoadPart) right).getLeftField());
        }
        if (left.getClass().equals(FieldPart.class) && right.getClass().equals(RoadPart.class) && up.getClass().equals(CitiPart.class) && down.getClass().equals(RoadPart.class)) {
            left.setRight(((RoadPart) down).getLeftField());
            ((RoadPart) down).getLeftField().setLeft(left);
            left.setAcross(((RoadPart) right).getRightField());
            ((RoadPart) right).getRightField().setAcross(left);
            ((RoadPart) down).getLeftField().setRight(((RoadPart) right).getRightField());
            ((RoadPart) right).getRightField().setLeft(((RoadPart) down).getLeftField());
            ((RoadPart) down).getRightField().setRight(((RoadPart) right).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(((RoadPart) down).getRightField());
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(FieldPart.class) && up.getClass().equals(CitiPart.class) && down.getClass().equals(RoadPart.class)) {
            right.setLeft(((RoadPart) down).getRightField());
            ((RoadPart) down).getRightField().setRight(right);
            right.setAcross(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setAcross(right);
            ((RoadPart) down).getRightField().setLeft(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setRight(((RoadPart) down).getRightField());
            ((RoadPart) down).getLeftField().setLeft(((RoadPart) left).getRightField());
            ((RoadPart) left).getRightField().setRight(((RoadPart) down).getLeftField());
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(RoadPart.class) && up.getClass().equals(CitiPart.class) && down.getClass().equals(RoadPart.class)) {
            ((RoadPart) left).getLeftField().setAcross(((RoadPart) right).getRightField());
            ((RoadPart) right).getRightField().setAcross(((RoadPart) left).getLeftField());
            ((RoadPart) down).getRightField().setRight(((RoadPart) right).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(((RoadPart) down).getRightField());
            ((RoadPart) down).getLeftField().setLeft(((RoadPart) left).getRightField());
            ((RoadPart) left).getRightField().setRight(((RoadPart) down).getLeftField());
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(RoadPart.class) && up.getClass().equals(FieldPart.class) && down.getClass().equals(RoadPart.class)) {
            ((RoadPart) left).getLeftField().setAcross(((RoadPart) right).getRightField());
            ((RoadPart) left).getLeftField().setLeft(up);
            up.setRight(((RoadPart) left).getLeftField());
            ((RoadPart) right).getRightField().setAcross(((RoadPart) left).getLeftField());
            ((RoadPart) right).getRightField().setRight(up);
            up.setLeft(  ((RoadPart) right).getRightField());
            ((RoadPart) down).getRightField().setRight(((RoadPart) right).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(((RoadPart) down).getRightField());
            ((RoadPart) down).getLeftField().setLeft(((RoadPart) left).getRightField());
            ((RoadPart) left).getRightField().setRight(((RoadPart) down).getLeftField());
        }
        if (left.getClass().equals(FieldPart.class) && right.getClass().equals(FieldPart.class) && up.getClass().equals(RoadPart.class) && down.getClass().equals(RoadPart.class)) {
            left.setLeft(((RoadPart) up).getRightField());
            ((RoadPart) up).getRightField().setRight(left);
            left.setRight(((RoadPart) down).getLeftField());
            ((RoadPart) down).getLeftField().setLeft(left);
            ((RoadPart) up).getRightField().setAcross(((RoadPart) down).getLeftField());
            ((RoadPart) down).getLeftField().setAcross(((RoadPart) up).getRightField());
            right.setRight(((RoadPart) up).getLeftField());
            ((RoadPart) up).getLeftField().setLeft(right);
            right.setLeft(((RoadPart) down).getRightField());
            ((RoadPart) down).getRightField().setRight(right);
            ((RoadPart) up).getLeftField().setAcross(((RoadPart) down).getRightField());
            ((RoadPart) down).getRightField().setAcross(((RoadPart) up).getLeftField());
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(FieldPart.class) && up.getClass().equals(FieldPart.class) && down.getClass().equals(RoadPart.class)) {
            right.setLeft(((RoadPart) down).getRightField());
            ((RoadPart) down).getRightField().setRight(right);
            right.setAcross(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setAcross(right);
            ((RoadPart) down).getRightField().setLeft(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setRight(((RoadPart) down).getRightField());
            ((RoadPart) down).getLeftField().setLeft(((RoadPart) left).getRightField());
            ((RoadPart) left).getRightField().setRight(((RoadPart) down).getLeftField());
            up.setRight(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setLeft(up);
            up.setAcross(((RoadPart) down).getRightField());
            ((RoadPart) down).getRightField().setAcross(up);
        }
        if (left.getClass().equals(RoadPart.class) && right.getClass().equals(RoadPart.class) && up.getClass().equals(RoadPart.class) && down.getClass().equals(RoadPart.class)) {
            ((RoadPart) down).getLeftField().setLeft(((RoadPart) left).getRightField());
            ((RoadPart) left).getRightField().setRight(((RoadPart) down).getLeftField());
            ((RoadPart) down).getRightField().setRight(((RoadPart) right).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(((RoadPart) down).getRightField());
            ((RoadPart) up).getLeftField().setLeft(((RoadPart) right).getRightField());
            ((RoadPart) right).getRightField().setRight(((RoadPart) up).getLeftField());
            ((RoadPart) up).getRightField().setRight(((RoadPart) left).getLeftField());
            ((RoadPart) left).getLeftField().setLeft(((RoadPart) up).getRightField());
        }
        if (left.getClass().equals(FieldPart.class) && right.getClass().equals(FieldPart.class) && up.getClass().equals(FieldPart.class) && down.getClass().equals(RoadPart.class)) {
            ((RoadPart) down).getLeftField().setLeft(left);
            left.setRight(((RoadPart) down).getLeftField());
            ((RoadPart) down).getLeftField().setAcross(up);
            up.setAcross(((RoadPart) down).getLeftField());
            ((RoadPart) down).getLeftField().setRight(right);
            ((RoadPart) down).getRightField().setLeft(left);
            ((RoadPart) down).getRightField().setAcross(up);
            ((RoadPart) down).getRightField().setRight(right);
            right.setLeft(((RoadPart) down).getRightField());
        }
        if (left.getClass().equals(CitiPart.class) && right.getClass().equals(RoadPart.class) && up.getClass().equals(CitiPart.class) && down.getClass().equals(RoadPart.class)) {
            ((RoadPart) down).getLeftField().setRight(((RoadPart) right).getRightField());
            ((RoadPart) right).getRightField().setLeft(((RoadPart) down).getLeftField());
            ((RoadPart) down).getRightField().setRight(((RoadPart) right).getLeftField());
            ((RoadPart) right).getLeftField().setLeft(((RoadPart) down).getRightField());
        }
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(int rotation) {
        this.rotation = rotation;
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
        getMonastery().setColumn(column);

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
        getMonastery().setRow(row);

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
            up = new CitiPart(square.getUp().isConnectedToTheLeft(), square.getUp().isConnectedToTheRight(), square.getUp().isConnectedAcross(), citiPart.isShield(), square.getUp().getPawnPosition());
        } else if (square.getUp().getClass() == FieldPart.class) {
            up = new FieldPart(square.getUp().isConnectedToTheLeft(), square.getUp().isConnectedToTheRight(), square.getUp().isConnectedAcross(), square.getUp().getPawnPosition());
        } else if (square.getUp().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getUp();
            FieldPart leftField = new FieldPart(roadPart.getLeftField().isConnectedToTheLeft(), roadPart.getLeftField().isConnectedToTheRight(), roadPart.getLeftField().isConnectedAcross(), roadPart.getLeftField().getPawnPosition());
            FieldPart rightField = new FieldPart(roadPart.getRightField().isConnectedToTheLeft(), roadPart.getRightField().isConnectedToTheRight(), roadPart.getRightField().isConnectedAcross(), roadPart.getRightField().getPawnPosition());
            up = new RoadPart(square.getUp().isConnectedToTheLeft(), square.getUp().isConnectedToTheRight(), square.getUp().isConnectedAcross(), leftField, rightField, square.getUp().getPawnPosition());
        } else {up = new EmptyPart();}

        if (square.getLeft().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getLeft();
            left = new CitiPart(square.getLeft().isConnectedToTheLeft(), square.getLeft().isConnectedToTheRight(), square.getLeft().isConnectedAcross(), citiPart.isShield(), square.getLeft().getPawnPosition());
        } else if (square.getLeft().getClass() == FieldPart.class) {
            left = new FieldPart(square.getLeft().isConnectedToTheLeft(), square.getLeft().isConnectedToTheRight(), square.getLeft().isConnectedAcross(), square.getLeft().getPawnPosition());
        } else if (square.getLeft().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getLeft();
            FieldPart leftField = new FieldPart(roadPart.getLeftField().isConnectedToTheLeft(), roadPart.getLeftField().isConnectedToTheRight(), roadPart.getLeftField().isConnectedAcross(), roadPart.getLeftField().getPawnPosition());
            FieldPart rightField = new FieldPart(roadPart.getRightField().isConnectedToTheLeft(), roadPart.getRightField().isConnectedToTheRight(), roadPart.getRightField().isConnectedAcross(), roadPart.getRightField().getPawnPosition());
            left = new RoadPart(square.getLeft().isConnectedToTheLeft(), square.getLeft().isConnectedToTheRight(), square.getLeft().isConnectedAcross(), leftField, rightField, square.getLeft().getPawnPosition());
        } else {left = new EmptyPart();}

        if (square.getRight().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getRight();
            right = new CitiPart(square.getRight().isConnectedToTheLeft(), square.getRight().isConnectedToTheRight(), square.getRight().isConnectedAcross(), citiPart.isShield(), square.getRight().getPawnPosition());
        } else if (square.getRight().getClass() == FieldPart.class) {
            right = new FieldPart(square.getRight().isConnectedToTheLeft(), square.getRight().isConnectedToTheRight(), square.getRight().isConnectedAcross(), square.getRight().getPawnPosition());
        } else if (square.getRight().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getRight();
            FieldPart leftField = new FieldPart(roadPart.getLeftField().isConnectedToTheLeft(), roadPart.getLeftField().isConnectedToTheRight(), roadPart.getLeftField().isConnectedAcross(), roadPart.getLeftField().getPawnPosition());
            FieldPart rightField = new FieldPart(roadPart.getRightField().isConnectedToTheLeft(), roadPart.getRightField().isConnectedToTheRight(), roadPart.getRightField().isConnectedAcross(), roadPart.getRightField().getPawnPosition());
            right = new RoadPart(square.getRight().isConnectedToTheLeft(), square.getRight().isConnectedToTheRight(), square.getRight().isConnectedAcross(), leftField, rightField, square.getRight().getPawnPosition());
        } else {right = new EmptyPart();}

        if (square.getDown().getClass() == CitiPart.class) {
            CitiPart citiPart = (CitiPart) square.getDown();
            down = new CitiPart(square.getDown().isConnectedToTheLeft(), square.getDown().isConnectedToTheRight(), square.getDown().isConnectedAcross(), citiPart.isShield(), square.getDown().getPawnPosition());
        } else if (square.getDown().getClass() == FieldPart.class) {
            down = new FieldPart(square.getDown().isConnectedToTheLeft(), square.getDown().isConnectedToTheRight(), square.getDown().isConnectedAcross(), square.getDown().getPawnPosition());
        } else if (square.getDown().getClass() == RoadPart.class) {
            RoadPart roadPart = (RoadPart) square.getDown();
            FieldPart leftField = new FieldPart(roadPart.getLeftField().isConnectedToTheLeft(), roadPart.getLeftField().isConnectedToTheRight(), roadPart.getLeftField().isConnectedAcross(), roadPart.getLeftField().getPawnPosition());
            FieldPart rightField = new FieldPart(roadPart.getRightField().isConnectedToTheLeft(), roadPart.getRightField().isConnectedToTheRight(), roadPart.getRightField().isConnectedAcross(), roadPart.getRightField().getPawnPosition());
            down = new RoadPart(square.getDown().isConnectedToTheLeft(), square.getDown().isConnectedToTheRight(), square.getDown().isConnectedAcross(), leftField, rightField, square.getDown().getPawnPosition());
        } else {down = new EmptyPart();}

        Monastery monastery = new Monastery(square.isThereMonastery());

        String mainImage = square.getMainImage();

        int rotation = square.getRotation();

        return new Square(up, left, right, down, monastery, mainImage, rotation);
    }

    public static Square copyAndTurnLeftSquare(Square square) {

        Square turnLeft = Square.copySquare(square);
        return new Square(turnLeft.getRight(), turnLeft.getUp(), turnLeft.getDown(), turnLeft.getLeft(), turnLeft.getMonastery(), turnLeft.getMainImage(), turnLeft.getRotation()-90);
    }

    public static Square copyAndTurnRightSquare(Square square) {

        Square turnRight = Square.copySquare(square);
        return new Square(turnRight.getLeft(), turnRight.getDown(), turnRight.getUp(), turnRight.getRight(), turnRight.getMonastery(), turnRight.getMainImage(), turnRight.getRotation()+90);
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
