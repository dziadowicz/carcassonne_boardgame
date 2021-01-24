package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Citi implements Removable{

    private List<Part> partsList = new ArrayList<>();
    private List<Pawn> pawnList = new ArrayList<>();

    public List<Part> getPartsList() {
        return partsList;
    }

    public void setPartsList(Part part) {
        partsList.add(part);
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
    public boolean isAvailableForPawn() {

        return false;
    }

    @Override
    public void putPawn(Player player, Part part) {
        pawnList.add(new Pawn(player, part));
        part.putPawn(player);
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
    public void removePawn() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citi)) return false;

        Citi citi = (Citi) o;

        if (isTherePawn() != citi.isTherePawn()) return false;
        return getPartsList() != null ? getPartsList().equals(citi.getPartsList()) : citi.getPartsList() == null;
    }

//    @Override
//    public int hashCode() {
//        int result = getPartsSet() != null ? getPartsSet().hashCode() : 0;
//        result = 31 * result + (isTherePawn ? 1 : 0);
//        return result;
//    }
}
