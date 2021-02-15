package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.Playable;
import com.game.carcassonne.carcassonnegame.squares.Square;

public interface Connectible extends Playable {

    boolean isExternalConnected();
    void setExternalConnection();
    boolean isConnectedToTheLeft();
    boolean isConnectedToTheRight();
    boolean isConnectedAcross();
    int getRaw();
    void setRow(int raw);
    int getColumn();
    void setColumn(int column);
    void setPosition(String position);
    void setMaster(Playable playable);
    Playable getMaster();
    String getPosition();
    boolean getIsTherePawn();
    void putPawn(Player player);
    String getPawnPosition();
    Connectible getLeft();
    Connectible getRight();
    Connectible getAcross();
    Connectible getExternal();
    void setLeft(Connectible left);
    void setRight(Connectible right);
    void setAcross(Connectible across);
    void setExternal(Connectible external);
}
