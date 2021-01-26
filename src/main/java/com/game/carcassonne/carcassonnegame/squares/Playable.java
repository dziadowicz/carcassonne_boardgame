package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Part;

import java.util.List;

public interface Playable {

    boolean isAvailableForPawn(Board board);
    void putPawn(Player player, Part part);
    List<Pawn> getPawnList();
    boolean isTherePawn();
    List<Part> getPartsList();
    void calculate(Part part);
}
