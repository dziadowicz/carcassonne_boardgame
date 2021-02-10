package com.game.carcassonne.carcassonnegame.visual;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ToolBar {

    private static Button button1(Board board, int size, GridPane grid, int gridSize) {
        Image wall2 = new Image("file:src/main/resources/wall3.jpg");
        ImageView imageView = new ImageView(wall2);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        Button button = new Button("Process", imageView);
        Square square = SquareList.getSquares().get(0);
        button.setOnAction(event -> {
            board.putSquareRandomly(square);
            ImageView imageView1 = new ImageView(new Image(square.getMainImage()));
            imageView1.setFitWidth(size);
            imageView1.setFitHeight(size);
            int gridColumn = square.getColumn() - (board.getBoardSize() / 2 - gridSize / 2);
            int gridRow = square.getRow() - (board.getBoardSize() / 2 - gridSize / 2);
            grid.add(imageView1, gridColumn, gridRow);
        });
        return button;
    }

    private static Button button2(Stage stage, GridPane grid, ScrollPane scrollPane, GridPane mainGrid) {
        Button button = new Button("Refresh");
        button.setOnAction(event -> {

            Scene scene = new Scene(mainGrid);
            stage.setScene(scene);
            stage.show();
        });
        return button;
    }

    public static GridPane toolBar(Board board, int size, GridPane grid, int gridSize, Stage stage, ScrollPane scrollPane, GridPane mainGrid) {
        GridPane toolBar = new GridPane();

        toolBar.addRow(0, button1(board, size, grid, gridSize), button2(stage, grid, scrollPane, mainGrid));

        return toolBar;
    }
}
