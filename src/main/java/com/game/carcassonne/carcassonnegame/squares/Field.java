package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field implements Playable{

    private boolean isTherePawn = false;
    private List<Connectible> partsList = new ArrayList<>();
    private List<Pawn> pawnList = new ArrayList<>();

    @Override
    public boolean isAvailableForPawn(Board board) {
        return !isTherePawn();
    }

    @Override
    public List<Pawn> getPawnList() {
        return pawnList;
    }

    @Override
    public boolean isTherePawn() {

        if (pawnList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void putPawn(Player player, Connectible connectible) {
        pawnList.add(new Pawn(player, connectible));
        connectible.putPawn(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;

        Field field = (Field) o;

        if (isTherePawn() != field.isTherePawn()) return false;
        if (getPartsList() != null ? !getPartsList().equals(field.getPartsList()) : field.getPartsList() != null)
            return false;
        return getPawnList() != null ? getPawnList().equals(field.getPawnList()) : field.getPawnList() == null;
    }

    @Override
    public List<Connectible> getPartsList() {
        return partsList;
    }

    @Override
    public void calculate(Connectible connectible) {
        partsList.clear();
        partsList.add(connectible);
        int size;
        do {
            size = partsList.size();
            for (Connectible connectible1: partsList) {
                if (connectible1.isConnectedToTheLeft() && !partsList.contains(connectible1.getLeft())) partsList.add(connectible1.getLeft());
                if (connectible1.isConnectedToTheRight() && !partsList.contains(connectible1.getRight())) partsList.add(connectible1.getRight());
                if (connectible1.isConnectedAcross() && !partsList.contains(connectible1.getAcross())) partsList.add(connectible1.getAcross());
                if (connectible1.isExternalConnected() && !partsList.contains(connectible1.getExternal())) partsList.add(connectible1.getExternal());
            }

        } while (partsList.size() != size);
    }

    //    @Override
//    public int hashCode() {
//        int result = (isTherePawn ? 1 : 0);
//        result = 31 * result + (getPartsSet() != null ? getPartsSet().hashCode() : 0);
//        return result;
//    }
}
