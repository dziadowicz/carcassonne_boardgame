package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Measurable {

    Connectible getUp();
    Connectible getLeft();
    Connectible getRight();
    Connectible getDown();
    int getColumn();
    int getRow();
    String getMainImage();
    void setImageView(ImageView imageViev);
    ImageView getImageView();
}
