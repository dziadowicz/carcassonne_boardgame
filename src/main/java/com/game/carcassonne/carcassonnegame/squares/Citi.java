package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

import java.util.ArrayList;
import java.util.List;

public class Citi implements Removable{

    private List<Connectible> partsList = new ArrayList<>();
    private List<Pawn> pawnList = new ArrayList<>();

    public List<Connectible> getPartsList() {
        return partsList;
    }

    public void setPartsList(Connectible connectible) {
        partsList.add(connectible);
    }

    @Override
    public boolean isTherePawn(){

        if (pawnList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isAvailableForPawn(Board board) {
        return !isTherePawn();
    }

    @Override
    public void putPawn(Player player, Connectible connectible) {
        pawnList.add(new Pawn(player, connectible));
        connectible.putPawn(player);
    }

    @Override
    public List<Pawn> getPawnList() {
        return pawnList;
    }

    @Override
    public boolean checkIfIsFinished() {
        return false;
    }

    @Override
    public void closeAndRemovePawns() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citi)) return false;

        Citi citi = (Citi) o;

        if (isTherePawn() != citi.isTherePawn()) return false;
        return getPartsList() != null ? getPartsList().equals(citi.getPartsList()) : citi.getPartsList() == null;
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
//        int result = getPartsSet() != null ? getPartsSet().hashCode() : 0;
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
