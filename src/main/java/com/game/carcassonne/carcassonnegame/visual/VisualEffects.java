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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class VisualEffects extends Application {

    private Image imageback = new Image("file:src/main/resources/wallpaper.jpg");
    private Image card = new Image("file:src/main/resources/squares/S_00.png");
    //    private Image square = new Image("file:src/main/resources/squares/S_04.png");
    private Image square2 = new Image("file:src/main/resources/squares/S_68.png");
    private Image wall1 = new Image("file:src/main/resources/wall2.jpg");
    private Image wall2 = new Image("file:src/main/resources/wall3.jpg");
    private Image square31 = new Image("file:src/main/resources/squares/S_15.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane squares = new FlowPane(Orientation.HORIZONTAL);
    private int gridSize = 13;
    private GridPane grid = new GridPane();
    Deque<Square> squareDeque = SquareList.shuffledSquareDeque();
    private Square square;
    private ImageView squareToPut = new ImageView(wall2);
    private List<Node> nodeList = new ArrayList<>();
    private GridPane mainGrid = new GridPane();
    private List<Node> pawnList = new ArrayList<>();
    private int pawnPosition = 0;

    public void clearAvailableSquares() {
        for (Node node: nodeList) {
            grid.getChildren().remove(node);
        }
        nodeList.clear();
    }

    public void showAvailableSquares(Board board) {
        square = squareDeque.peek();
        board.setAvailableSquaresList(square);
        clearAvailableSquares();
        ImageView imageView1 = new ImageView(new Image(square.getMainImage()));
        imageView1.setFitWidth(120);
        imageView1.setFitHeight(120);
        imageView1.setRotate(square.getRotation());
        square.setImageView(imageView1);
        mainGrid.getChildren().remove(squareToPut);
        squareToPut = imageView1;
        mainGrid.add(squareToPut, 2, 0);
        for (Measurable measurable: board.getAvailableSquaresList()) {
            Button button = new Button("PUT HERE");
            button.setMinHeight(120);
            button.setMinWidth(120);
            button.setOnAction(event -> {
                try {
                    square = squareDeque.pop();
                    if (board.putSquare(measurable.getColumn(), measurable.getRow(), square)) {
                        setSquareOnGrid();
                    };
                } catch (WrongPutException e) {
                    System.out.println("Wrong put");
                } finally {
     //               showAvailableSquares(board);
                }
            });
            ImageView imageView = new ImageView(new Image(measurable.getMainImage()));
            imageView.setFitWidth(120);
            imageView.setFitHeight(120);
            measurable.setImageView(imageView);
            grid.add(button, measurable.getColumn(), measurable.getRow());
            nodeList.add(button);
        }
    }

    public void setSquareOnGrid() {
        ImageView imageView = new ImageView(new Image(square.getMainImage()));
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setRotate(square.getRotation());
        square.setImageView(imageView);
        grid.add(square.getImageView(), square.getColumn(), square.getRow());
    }

    public void putPawn(Square square) {
        pawnList.clear();
        List<String> imagesList = new ArrayList<>();
        imagesList.add("file:src/main/resources/pawns/rp00.png");
        imagesList.add("file:src/main/resources/pawns/rp01.png");
        imagesList.add("file:src/main/resources/pawns/rp02.png");
        imagesList.add("file:src/main/resources/pawns/rp03.png");
        imagesList.add("file:src/main/resources/pawns/rp04.png");
        imagesList.add("file:src/main/resources/pawns/rp05.png");
        imagesList.add("file:src/main/resources/pawns/rp06.png");
        imagesList.add("file:src/main/resources/pawns/rp07.png");
        imagesList.add("file:src/main/resources/pawns/rp08.png");
        for (String pawn: imagesList
             ) {
            Button button = new Button();
            button.setGraphic(new ImageView(new Image(pawn)));
            button.setRotate(square.getRotation());
            button.setMinWidth(120);
            button.setMinHeight(120);
            pawnList.add(button);
        }

        grid.add(pawnList.get(pawnPosition), square.getColumn(), square.getRow());
        if (pawnPosition < pawnList.size()-1) {
            pawnPosition++;
        } else {
            pawnPosition = 0;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Board board = new Board(SquareList.getSquares().size());

        grid = ShowBoard.showBoard(board, 120, 13);
        BackgroundFill backgroundFill = new BackgroundFill(Color.BURLYWOOD, null, null);
        backgroundFill.getFill();
        Background background1 = new Background(backgroundFill);
        Background background2 = new Background(backgroundFill);
        grid.setBackground(background1);

        Button button = new Button("Put square");
        button.setOnAction(event ->  {

            square = squareDeque.pop();
            clearAvailableSquares();

            if (board.putSquareRandomly(square)) {
                setSquareOnGrid();
            }
        });

        ScrollPane scrollPane = new ScrollPane(grid);
        mainGrid.setBackground(background2);

        Button showAvailable = new Button("Show available");
        showAvailable.setOnAction(event -> {
            clearAvailableSquares();
            showAvailableSquares(board);
        });

        Button rotate = new Button("Rotate square");
        rotate.setOnAction(event -> {
            square = Square.copyAndTurnRightSquare(squareDeque.pop());
            squareDeque.push(square);
            clearAvailableSquares();
            showAvailableSquares(board);
        });

        Button pawnPosition = new Button("Change Pawn position");
        pawnPosition.setOnAction(event -> {
            if (square.getColumn() < 71) {
                ImageView imageView = new ImageView(new Image("file:src/main/resources/pawns/red/" + square.getUp().getPawnPosition()));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                imageView.setRotate(square.getRotation());
                grid.add(imageView, square.getColumn(), square.getRow());
            }
        });

        button.setMinWidth(120);
        button.setMinHeight(120);
        mainGrid.add(button, 0, 0);
        mainGrid.add(showAvailable, 1, 0);
        squareToPut.setFitHeight(120);
        squareToPut.setFitWidth(120);
        mainGrid.add(squareToPut, 2, 0);
        mainGrid.add(rotate, 3, 0);
        mainGrid.add(pawnPosition, 4, 0);
        mainGrid.add(scrollPane, 0, 1, 1000, 1000);

        Scene scene = new Scene(mainGrid, 1000, 600, Color.BLACK);

        primaryStage.setTitle("Carcassonne");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        showAvailableSquares(board);
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

