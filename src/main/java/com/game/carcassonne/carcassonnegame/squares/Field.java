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
    private Set<Connectible> partsSet = new HashSet<>();
    private List<Pawn> pawnList = new ArrayList<>();

    public Set<Connectible> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Connectible connectible) {
        partsSet.add(connectible);
    }

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

        if (isTherePawn != field.isTherePawn) return false;
        return getPartsSet() != null ? getPartsSet().equals(field.getPartsSet()) : field.getPartsSet() == null;
    }

    @Override
    public List<Connectible> getPartsList() {
        return null;
    }

    @Override
    public void calculate(Connectible connectible) {

    }

    //    @Override
//    public int hashCode() {
//        int result = (isTherePawn ? 1 : 0);
//        result = 31 * result + (getPartsSet() != null ? getPartsSet().hashCode() : 0);
//        return result;
//    }
}
