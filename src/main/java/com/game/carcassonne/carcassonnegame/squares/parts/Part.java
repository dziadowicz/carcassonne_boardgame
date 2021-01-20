package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.squares.Playable;
import com.game.carcassonne.carcassonnegame.squares.Square;

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
    void setPosition(String position);
    void setMaster(Playable playable);
    Playable getMaster();
    String getPosition();
    boolean getIsTherePawn();
}
