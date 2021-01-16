package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.players.Player;

public class EmptyPart implements Part{
    @Override
    public void checkAvailability() {

    }

    @Override
    public void putPawn(Player player) {

    }

    @Override
    public String toString() {
        return "EmptyPart{}";
    }

    @Override
    public boolean isExternalConnection() {
        return false;
    }

    @Override
    public void setExternalConnection() {

    }

    @Override
    public boolean isConnectionToTheLeft() {
        return false;
    }

    @Override
    public boolean isConnectionToTheRight() {
        return false;
    }

    @Override
    public boolean isConnectionAcross() {
        return false;
    }

    @Override
    public int getRaw() {
        return 0;
    }

    @Override
    public void setRaw(int raw) {

    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public void setColumn(int column) {

    }

    @Override
    public void setPosition(String position) {

    }

    @Override
    public String getPosition() {
        return null;
    }
}
