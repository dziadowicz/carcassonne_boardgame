package com.game.carcassonne.carcassonnegame.squares.parts;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.Playable;
import com.game.carcassonne.carcassonnegame.squares.Square;

import java.util.List;

public class EmptyPart implements Connectible {
    @Override
    public boolean isAvailableForPawn(Board board) {
        return false;
    }

    @Override
    public void putPawn(Player player, Connectible connectible) {

    }

    @Override
    public List<Pawn> getPawnList() {
        return null;
    }

    @Override
    public boolean isTherePawn() {
        return false;
    }

    @Override
    public void putPawn(Player player) {

    }

    @Override
    public boolean getIsTherePawn() {
        return false;
    }

    @Override
    public String toString() {
        return "EmptyPart{}";
    }

    @Override
    public boolean isExternalConnected() {
        return false;
    }

    @Override
    public void setExternalConnection() {

    }

    @Override
    public boolean isConnectedToTheLeft() {
        return false;
    }

    @Override
    public boolean isConnectedToTheRight() {
        return false;
    }

    @Override
    public boolean isConnectedAcross() {
        return false;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void setRow(int row) {

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

    @Override
    public Connectible getLeft() {
        return null;
    }

    @Override
    public Connectible getRight() {
        return null;
    }

    @Override
    public Connectible getAcross() {
        return null;
    }

    @Override
    public Connectible getExternal() {
        return null;
    }

    @Override
    public void setLeft(Connectible left) {

    }

    @Override
    public void setRight(Connectible right) {

    }

    @Override
    public void setAcross(Connectible across) {

    }

    @Override
    public void setExternal(Connectible external) {

    }

    @Override
    public void setMaster(Playable playable) {

    }


    @Override
    public String getPawnPosition() {
        return null;
    }

    @Override
    public List<Connectible> getPartsList() {
        return null;
    }

    @Override
    public void calculate(Connectible connectible) {

    }

    @Override
    public Playable getMaster() {
        return null;
    }
}
