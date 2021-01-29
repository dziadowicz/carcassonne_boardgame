package com.game.carcassonne.carcassonnegame.game;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.players.PlayerList;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;

import java.util.Deque;
import java.util.List;

public class Game {

    private int playersNumber;
    private Deque<Square> squareDeque = SquareList.shuffledSquareDeque();
    public Board board = new Board(squareDeque.size());

    public Game(int playersNumber){ //throws WrongPlayersNumberException {
        this.playersNumber = playersNumber;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public void newGame() throws WrongPlayersNumberException {
        PlayerList playerList = new PlayerList(getPlayersNumber());
        List<Player> players = playerList.getPlayers();

        int activePLayer = 0;

        while (squareDeque.size() > 0) {

            while (!board.isThereAnyPossibleMove(squareDeque.peek())){
                squareDeque.pop();
                System.out.println("No possible move!");
            }

            Square square = squareDeque.pop();

//            System.out.println("Player " + players.get(activePLayer).getColor() + " turn.");

//            board.putSquareRandomly(square);
            players.get(activePLayer).turn(board, square);
            System.out.println(board.getAllPartsList());

//            for (Squares squares: availableSquaresList
//                 ) {
//                System.out.println(squares.getUp());
//            }

            if (activePLayer < (players.size()-1)) {
                activePLayer++;
            } else {
                activePLayer = 0;
            }
        }

    }
}
