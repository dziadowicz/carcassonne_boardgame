package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.EmptyPart;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EmptySquare implements Measurable {

    private int column;
    private int raw;
    String mainImage = "file:src/main/resources/wall2.jpg";
    ImageView imageView;

    public EmptySquare(int column, int raw) {
        this.column = column;
        this.raw = raw;
    }

    @Override
    public void setRotation(int rotation) {

    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public String getMainImage() {
        return mainImage;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public int getRow() {
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
