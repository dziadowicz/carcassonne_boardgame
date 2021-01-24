package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarcassonneGameApplication {

    public static void main(String[] args) {

//        Set<Square> set = new HashSet<>();
//        List<Square> list = new ArrayList<>();
//        Square a = SquareList.getStartingSquare();
//        Square b = Square.copyAndTurnRightSquare(a);
//        Square c = Square.copyAndTurnLeftSquare(a);
//        set.add(a);
//        set.add(b);
//        set.add(c);
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        System.out.println(set.size() + " " + list.size());
//        List<Square> squareList = set.toArray();
//        System.out.println(set.size() + " " + list.size());


            Game game = new Game(4);
            try {
                game.newGame();
            } catch (WrongPlayersNumberException e) {
                System.out.println("Incorrect number of players");
            }
    }
}
