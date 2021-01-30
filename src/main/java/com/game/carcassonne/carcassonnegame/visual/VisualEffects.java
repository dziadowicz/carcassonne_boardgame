package com.game.carcassonne.carcassonnegame.visual;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisualEffects extends Application {

    private Image imageback = new Image("file:src/main/resources/wallpaper.jpg");
    private Image card = new Image("file:src/main/resources/squares/S_00.png");
    private Image square = new Image("file:src/main/resources/squares/S_04.png");
    private Image square2 = new Image("file:src/main/resources/squares/S_68.png");
    private Image wall1 = new Image("file:src/main/resources/wall2.jpg");
    private Image wall2 = new Image("file:src/main/resources/wall3.jpg");
    private Image square31 = new Image("file:src/main/resources/squares/S_15.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane squeres = new FlowPane(Orientation.HORIZONTAL);

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(background);

        int size = 100;

        ImageView img = new ImageView(card);
        img.setFitHeight(size);
        img.setFitWidth(size);
        img.setRotate(90);
        ImageView img2 = new ImageView(square);
        img2.setFitHeight(size);
        img2.setFitWidth(size);
        img2.setRotate(-90);
        ImageView img3 = new ImageView(square2);
        img3.setFitWidth(size);
        img3.setFitHeight(size);
        ImageView img4 = new ImageView(card);
        img4.setFitHeight(size);
        img4.setFitWidth(size);
        img4.setRotate(90);
        ImageView img5 = new ImageView(square31);
        img5.setFitHeight(size);
        img5.setFitWidth(size);
        img5.setRotate(-90);
        ImageView img6 = new ImageView(square2);
        img6.setFitWidth(size);
        img6.setFitHeight(size);
        ImageView wall = new ImageView(wall1);
        wall.setFitWidth(size);
        wall.setFitHeight(size);
        ImageView wall2 = new ImageView(wall1);
        wall2.setFitWidth(size);
        wall2.setFitHeight(size);
        cards.getChildren().add(wall);
        cards.getChildren().add(img);
        cards.getChildren().add(img3);
        cards.getChildren().add(img2);
        cards.getChildren().add(wall2);
        squeres.getChildren().add(img4);
        squeres.getChildren().add(img6);
        squeres.getChildren().add(img5);

        grid.add(cards, 0, 0, 1, 1);
        grid.add(squeres, 1, 1, 2, 2);

        Scene scene = new Scene(grid, 1000, 600, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
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
        Application.launch(args);
    }
}

