package com.game.carcassonne.carcassonnegame;

import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.WrongPlayersNumberException;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import com.game.carcassonne.carcassonnegame.squares.parts.CitiPart;
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



public class CarcassonneGameApplication extends Application {

    private Image imageback = new Image("file:src/main/resources/wallpaper.jpg");
    private Image card = new Image("file:src/main/resources/squares/S_00.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(card);
        img.setFitHeight(50);
        img.setFitWidth(50);
        img.setRotate(90);
        cards.getChildren().add(img);

        grid.add(cards, 0, 0, 100, 100);

        Scene scene = new Scene(grid, 1000, 600, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public CarcassonneGameApplication() {
        super();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }




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

        launch(args);

/*        Game game = new Game(4);
        try {
            game.newGame();
        } catch (WrongPlayersNumberException e) {
            System.out.println("Incorrect number of players");
        }*/
    }
}
