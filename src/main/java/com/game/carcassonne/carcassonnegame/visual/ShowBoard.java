package com.game.carcassonne.carcassonnegame.visual;

import com.game.carcassonne.carcassonnegame.board.Board;
import com.game.carcassonne.carcassonnegame.squares.EmptySquare;
import com.game.carcassonne.carcassonnegame.squares.Measurable;
import com.game.carcassonne.carcassonnegame.squares.Square;
import com.game.carcassonne.carcassonnegame.squares.SquareList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class ShowBoard {

   /* public static GridPane showBoard(Board board, int cellSize, int gridSize) {
        GridPane grid = new GridPane();
        for (int row = board.getBoardSize()/2-(gridSize/2); row < board.getBoardSize()/2+(gridSize/2+1); row++) {
            for (int column = board.getBoardSize()/2-(gridSize/2); column < board.getBoardSize()/2+(gridSize/2+1); column++) {

                if (board.getSquare(column, row).getClass().equals(EmptySquare.class)) {
                    ImageView imageView = new ImageView(new Image(board.getSquare(column, row).getMainImage()));
                    imageView.setFitWidth(cellSize);
                    imageView.setFitHeight(cellSize);
                    grid.add(imageView, column, row);
                } else {
                    GridPane pawns = new GridPane();
                    Image empty = new Image("file:src/main/resources/pawns/Empty.png");
                    ImageView redPawn = new ImageView(new Image("file:src/main/resources/pawns/redpawn.png"));
                    redPawn.setFitWidth(cellSize/3);
                    redPawn.setFitHeight(cellSize/3);
                    List<ImageView> pawnCellList = new ArrayList();
                    for (int i = 0; i < 9; i++) {
                        pawnCellList.add(new ImageView(empty));
                        pawnCellList.get(i).setFitHeight(cellSize / 3);
                        pawnCellList.get(i).setFitWidth(cellSize / 3);
                    }
                    pawns.add(pawnCellList.get(0), 0, 0);
                    pawns.add(pawnCellList.get(1), 1, 0);
                    pawns.add(pawnCellList.get(2), 2, 0);
                    pawns.add(pawnCellList.get(3), 0, 1);
                    pawns.add(pawnCellList.get(4), 1, 1);
                    pawns.add(pawnCellList.get(5), 2, 1);
                    pawns.add(pawnCellList.get(6), 0, 2);
                    pawns.add(pawnCellList.get(7), 1, 2);
                    pawns.add(pawnCellList.get(8), 2, 2);

                    pawns.setPrefSize(cellSize, cellSize);
                    BackgroundSize backgroundSize1 = new BackgroundSize(cellSize, cellSize, false, false, true, false);
                    BackgroundImage backgroundImage1 = new BackgroundImage(new Image(board.getSquare(column, row).getMainImage()), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize1);
                    Background background1 = new Background(backgroundImage1);
                    pawns.setBackground(background1);
                    grid.add(pawns, column, row);
                }
            }
        }
        return grid;
    }*/

    public static GridPane showBoard(Board board, int cellSize, int gridSize) {
        GridPane grid = new GridPane();
        int row = board.getBoardSize() / 2;
        int column = board.getBoardSize() / 2;
        Measurable square = board.getSquare(column, row);
        square.setImageView(new ImageView(new Image(square.getMainImage())));
        square.getImageView().setFitHeight(cellSize);
        square.getImageView().setFitWidth(cellSize);
        grid.add(square.getImageView(), column, row);

        return grid;
    }
}
