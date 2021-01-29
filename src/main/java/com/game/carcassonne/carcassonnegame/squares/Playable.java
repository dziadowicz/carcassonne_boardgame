package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Pawn;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.squares.parts.Connectible;

import java.util.List;

public interface Playable {

    boolean isAvailableForPawn(Board board);
    void putPawn(Player player, Connectible connectible);
    List<Pawn> getPawnList();
    boolean isTherePawn();
    List<Connectible> getPartsList();
    void calculate(Connectible connectible);
}
