package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import com.game.carcassonne.carcassonnegame.visual.VisualEffects;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javafx.application.Application.launch;


public class CarcassonneGameApplication{

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

        new Thread(() -> Application.launch(VisualEffects.class)).start();

/*        Game game = new Game(4);
        try {
            game.newGame();
        } catch (WrongPlayersNumberException e) {
            System.out.println("Incorrect number of players");
        }*/
    }
}
