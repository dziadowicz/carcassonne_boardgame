package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.PlayerList;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.SquareList;

public class CarcassonneGameApplication {

    public static void main(String[] args) {



            Game game = new Game(4);
            try {
                game.newGame();
            } catch (WrongPlayersNumberException e) {
                System.out.println("Incorrect number of players");
            }

    }


}
