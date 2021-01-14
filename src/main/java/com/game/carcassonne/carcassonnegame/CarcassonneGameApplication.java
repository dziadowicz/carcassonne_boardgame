package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.PlayerList;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.SquareList;

public class CarcassonneGameApplication {

    public static void main(String[] args) {

        Board board = new Board();
        board.createNewBoard(SquareList.getSquares().size());

        try {
            PlayerList playerList = new PlayerList(2);
            System.out.println(playerList.getPlayers().get(1));
        } catch (WrongPlayersNumberException e) {
            System.out.println("Wrong number of players" + e);
        }



        System.out.println(board.getSquare(SquareList.getSquares().size()/2, SquareList.getSquares().size()/2));

    }


}
