package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.squares.Playable;

public interface Part extends Playable {

    boolean isExternalConnection();
    void setExternalConnection();
    boolean isConnectionToTheLeft();
    boolean isConnectionToTheRight();
    boolean isConnectionAcross();
    int getRaw();
    void setRaw(int raw);
    int getColumn();
    void setColumn(int column);
    String position();
}
