package tiles;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import tiles.Board;

import java.net.CookieHandler;

public class Display {

    private GridPane gridPane;
    public static Label scoreBoard = new Label("Score: " + Tile.playerScore);
    public static Label combo = new Label("Current combo: " + Tile.playerCombo);
    public static Label longestCombo = new Label("Longest combo: " + Tile.longestCombo);

    public Display() {
        this.gridPane = new GridPane();
        gridPane.setPrefSize(100, 100);
        gridPane.setPadding(new Insets(10));
        gridPane.setGridLinesVisible(false);
        gridPane.setVgap(7.5);
        gridPane.setHgap(7.5);
    }
    public void drawBoard(Board board) {
        gridPane.setBackground(Background.EMPTY);
        int counter = 0;
        for(int i = 0; i < board.numRows; i++) {
            for(int j = 0; j < board.numCols; j++) {
                GridPane.setConstraints(board.tiles.get(counter),
                        j, i);
                gridPane.getChildren().add(board.tiles.get(counter));
                counter++;
            }
        }
        scoreBoard.setTextFill(Color.WHITE);
        combo.setTextFill(Color.WHITE);
        longestCombo.setTextFill(Color.WHITE);
        GridPane.setConstraints(scoreBoard, board.numCols, board.numRows);
        gridPane.getChildren().add(scoreBoard);
        GridPane.setConstraints(combo, board.numCols, board.numRows+1);
        gridPane.getChildren().add(combo);
        GridPane.setConstraints(longestCombo, board.numCols, board.numRows+2);
        gridPane.getChildren().add(longestCombo);
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}