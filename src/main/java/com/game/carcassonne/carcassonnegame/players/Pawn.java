package com.game.carcassonne.carcassonnegame.players;

import com.game.carcassonne.carcassonnegame.squares.Playable;

public class Pawn {

    private Player player;
    private Playable part;

    public Pawn(Player player, Playable part) {
        this.player = player;
        this.part = part;
    }
}
