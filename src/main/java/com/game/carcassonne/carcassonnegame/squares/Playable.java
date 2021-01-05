package com.game.carcassonne.carcassonnegame.squares;

import com.game.carcassonne.carcassonnegame.players.Player;

public interface Playable {

    void checkAvailability();
    void putPawn(Player player);
}
