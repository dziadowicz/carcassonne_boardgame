package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public interface Playable {

    boolean isAvailableForPawn();
    void putPawn(Player player);
    boolean getPawn();
}
