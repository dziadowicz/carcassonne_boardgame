package com.game.carcassonne.carcassonnegame.visual;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.board.WrongPutException;
import com.game.carcassonne.carcassonnegame.game.Game;
import com.game.carcassonne.carcassonnegame.players.*;
import com.game.carcassonne.carcassonnegame.squares.EmptySquare;
import com.game.carcassonne.carcassonnegame.squares.Measurable;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class VisualTests extends Application {

    private Image imageback = new Image("file:src/main/resources/wallpaper.jpg");
    private Image card = new Image("file:src/main/resources/squares/S_00.png");
//    private Image square = new Image("file:src/main/resources/squares/S_04.png");
    private Image square2 = new Image("file:src/main/resources/squares/S_68.png");
    private Image wall1 = new Image("file:src/main/resources/wall2.jpg");
    private Image wall2 = new Image("file:src/main/resources/wall3.jpg");
    private Image square31 = new Image("file:src/main/resources/squares/S_15.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane squeres = new FlowPane(Orientation.HORIZONTAL);
    private int gridSize = 13;
    private GridPane grid = new GridPane();
    Deque<Square> squareDeque = SquareList.shuffledSquareDeque();
    private Square square;
    private ImageView squareToPut = new ImageView(wall2);


    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

/*        HBox hbox = new HBox();

        Button b = new Button("add");
        b.setOnAction(ev -> hbox.getChildren().add(new Label("Test")));

        ScrollPane scrollPane = new ScrollPane(hbox);
        scrollPane.setFitToHeight(true);

        BorderPane root = new BorderPane(scrollPane);
        root.setPadding(new Insets(15));
        root.setTop(b);*//*

        GridPane mainGrid = new GridPane();

        GridPane grid = new GridPane();
        //      grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        //      grid.setHgap(0);
        //      grid.setVgap(0);
        grid.setBackground(background);

        int cellSize = 120;

        ImageView img = new ImageView(card);
        img.setFitHeight(cellSize);
        img.setFitWidth(cellSize);
        img.setRotate(90);
        ImageView img2 = new ImageView(square);
        img2.setFitHeight(cellSize);
        img2.setFitWidth(cellSize);
        img2.setRotate(-90);
        ImageView img3 = new ImageView(square2);
        img3.setFitWidth(cellSize);
        img3.setFitHeight(cellSize);
        ImageView img4 = new ImageView(card);
        img4.setFitHeight(cellSize);
        img4.setFitWidth(cellSize);
        img4.setRotate(90);
        ImageView img5 = new ImageView(square31);
        img5.setFitHeight(cellSize);
        img5.setFitWidth(cellSize);
        img5.setRotate(-90);
        ImageView img6 = new ImageView(square2);
        img6.setFitWidth(cellSize);
        img6.setFitHeight(cellSize);
        ImageView wall = new ImageView(wall1);
        wall.setFitWidth(cellSize);
        wall.setFitHeight(cellSize);
        ImageView wall22 = new ImageView(wall1);
        wall22.setFitWidth(cellSize);
        wall22.setFitHeight(cellSize);
        ImageView wall3 = new ImageView(wall1);
        wall3.setFitWidth(cellSize);
        wall3.setFitHeight(cellSize);
        ImageView wall4 = new ImageView(wall1);
        wall4.setFitWidth(cellSize);
        wall4.setFitHeight(cellSize);
        cards.getChildren().add(wall);
        cards.getChildren().add(img);
        cards.getChildren().add(img3);
        cards.getChildren().add(img2);
        cards.getChildren().add(wall22);
        squeres.getChildren().add(img4);
        squeres.getChildren().add(img6);
        squeres.getChildren().add(img5);

        //      grid.add(cards, 0, 0, 1, 1);
        //      grid.add(squeres, 1, 1, 2, 2);
*//*        grid.addRow(0, wall);
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(0, new ImageView(wall1));
        grid.addRow(1, img);
        grid.addRow(2, img3);
        grid.addRow(3, img2);
        grid.addRow(4, wall22);
        grid.addRow(5, wall3);
        grid.addRow(6, img4);
        grid.addRow(7, img6);
        grid.addRow(8, img5);
        grid.addRow(9, wall4);*//*

        Board board = new Board(SquareList.getSquares().size());
*//*        for (int raw = board.getBoardSize()/2-6; raw < board.getBoardSize()/2+7; raw++) {
            for (int column = board.getBoardSize()/2-6; column < board.getBoardSize()/2+7; column++) {

                if (board.getSquare(column, raw).getClass().equals(EmptySquare.class)) {
                    ImageView imageView = new ImageView(new Image(board.getSquare(column, raw).getMainImage()));
                    imageView.setFitWidth(size);
                    imageView.setFitHeight(size);
                    grid.add(imageView, column, raw);
                } else {
                    GridPane pawns = new GridPane();
                    Image empty = new Image("file:src/main/resources/pawns/Empty.png");
                    ImageView redPawn = new ImageView(new Image("file:src/main/resources/pawns/redpawn.png"));
                    redPawn.setFitWidth(size/3);
                    redPawn.setFitHeight(size/3);
                    List<ImageView> emptyCellList = new ArrayList();
                    for (int i = 0; i < 9; i++) {
                        emptyCellList.add(new ImageView(empty));
                        emptyCellList.get(i).setFitHeight(size / 3);
                        emptyCellList.get(i).setFitWidth(size / 3);
                    }
                    pawns.add(redPawn, 0, 0);
                    pawns.add(emptyCellList.get(1), 1, 0);
                    pawns.add(emptyCellList.get(2), 2, 0);
                    pawns.add(emptyCellList.get(3), 0, 1);
                    pawns.add(emptyCellList.get(4), 1, 1);
                    pawns.add(emptyCellList.get(5), 2, 1);
                    pawns.add(emptyCellList.get(6), 0, 2);
                    pawns.add(emptyCellList.get(7), 1, 2);
                    pawns.add(emptyCellList.get(8), 2, 2);

                    pawns.setPrefSize(size, size);
                    BackgroundSize backgroundSize1 = new BackgroundSize(size, size, false, false, true, false);
                    BackgroundImage backgroundImage1 = new BackgroundImage(new Image(board.getSquare(column, raw).getMainImage()), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize1);
                    Background background1 = new Background(backgroundImage1);
                    pawns.setBackground(background1);
                    grid.add(pawns, column, raw);
                }
            }
        }*//*
//        grid.setAlignment(Pos.CENTER);
        ScrollPane scrollPane = new ScrollPane(ShowBoard.showBoard(board, cellSize, gridSize));
        mainGrid.setBackground(background);
        mainGrid.addRow(0, scrollPane);
        ImageView toolBar = new ImageView(wall2);
        toolBar.setFitWidth(cellSize*5);
        toolBar.setFitHeight(cellSize);
        mainGrid.addRow(1, ToolBar.toolBar(board, cellSize, grid, gridSize, primaryStage, scrollPane, mainGrid));*/

        Board board = new Board(SquareList.getSquares().size());



        grid = ShowBoard.showBoard(board, 120, 13);



        Button button = new Button("Put square");
        button.setOnAction(event ->  {

            square = squareDeque.pop();
            board.setAvailableSquaresList(square);
            for (Measurable measurable: board.getAvailableSquaresList()) {
                ImageView imageView = measurable.getImageView();
                grid.getChildren().remove(imageView);
            }

            if (board.putSquareRandomly(square)) {
                ImageView imageView = new ImageView(new Image(square.getMainImage()));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                square.setImageView(imageView);
                grid.add(square.getImageView(), square.getColumn(), square.getRow());
            }
        });



        ScrollPane scrollPane = new ScrollPane(grid);
        GridPane mainGrid = new GridPane();

        Button showAvailable = new Button("Show available");
        showAvailable.setOnAction(event -> {
            square = squareDeque.peek();
            board.setAvailableSquaresList(square);
            for (Measurable measurable: board.getAvailableSquaresList()) {
                ImageView imageView = new ImageView(new Image(measurable.getMainImage()));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                measurable.setImageView(imageView);
                grid.add(measurable.getImageView(), measurable.getColumn(), measurable.getRow());
                ImageView imageView1 = new ImageView(new Image(square.getMainImage()));
                imageView1.setFitWidth(120);
                imageView1.setFitHeight(120);
                square.setImageView(imageView1);
                mainGrid.getChildren().remove(squareToPut);
                squareToPut = imageView1;
                mainGrid.addColumn(2, squareToPut);
            }
        });

        mainGrid.add(scrollPane, 0, 0, 100, 100);
        mainGrid.addColumn(2, button);
        mainGrid.addColumn(2, showAvailable);
        squareToPut.setFitHeight(120);
        squareToPut.setFitWidth(120);
        mainGrid.addColumn(2, squareToPut);
        Scene scene = new Scene(mainGrid, 1000, 600, Color.BLACK);

        primaryStage.setTitle("Carcassonne");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public int getGridSize() {
        return gridSize;
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

