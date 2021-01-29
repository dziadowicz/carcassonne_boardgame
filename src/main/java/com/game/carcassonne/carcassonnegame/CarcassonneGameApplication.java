package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class CarcassonneGameApplication {

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Group root = new Group();
//        Scene scene = new Scene(root, 300, 300, Color.BLACK);
//
//        Rectangle r = new Rectangle(25,25,250,250);
//        scene.setFill(Color.BLUE);
//
//        root.getChildren().add(r);
//        primaryStage.setTitle("BlackJack");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


//    public CarcassonneGameApplication() {
//        super();
//    }
//
//    @Override
//    public void init() throws Exception {
//        super.init();
//    }
//
//    @Override
//    public void stop() throws Exception {
//        super.stop();
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//    }

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
