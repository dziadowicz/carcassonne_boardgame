package com.game.carcassonne.carcassonnegame.game;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.players.Player;
import com.game.carcassonne.carcassonnegame.players.PlayerList;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import com.game.carcassonne.carcassonnegame.squares.Squares;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Game {

    private int playersNumber;
    private Deque<Square> squareDeque = SquareList.shuffledSquareDeque();
    public Board board = new Board(squareDeque.size());
    private PlayerList playerList = new PlayerList(getPlayersNumber());
    private List<Player> players = playerList.getPlayers();
    List<Squares> availableSquaresList = new ArrayList<>();

    public Game(int playersNumber){ //throws WrongPlayersNumberException {
        this.playersNumber = playersNumber;
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public void setAvailableSquaresList(Square square){


        for (int raw = 0; raw < board.getBoardSize(); raw++) {
            for (int column = 0; column < board.getBoardSize(); column++) {
                if (board.doesItFit(column, raw, square)) {
                    availableSquaresList.add(square);
                }
            }
        }
    }

    public boolean isThereAnyPossibleMove(Square square) {
        availableSquaresList.clear();

        setAvailableSquaresList(square);
        setAvailableSquaresList(Square.copyAndTurnRightSquare(square));
        setAvailableSquaresList(Square.copyAndTurnRightSquare(Square.copyAndTurnRightSquare(square)));
        setAvailableSquaresList(Square.copyAndTurnLeftSquare(square));

        if (availableSquaresList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void newGame() {

        int activePLayer = 0;
        while (squareDeque.size() > 0) {

            if (!isThereAnyPossibleMove(squareDeque.peek())){
                Square square = squareDeque.pop();
                System.out.println("No possible move!");
            }

            Square square = squareDeque.pop();

            availableSquaresList.clear();
                for (int i = 0; i < 4; i++) {
                    setAvailableSquaresList(square);
                }

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
