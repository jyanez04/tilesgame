package tiles;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import tiles.Board;

public class Display {

    public GridPane gridPane;

    public Display() {
        this.gridPane = new GridPane();
        gridPane.setPrefSize(100, 100);
        gridPane.setPadding(new Insets(10));
        gridPane.setGridLinesVisible(false);
        gridPane.setVgap(7.5);
        gridPane.setHgap(7.5);
    }
    public void drawBoard(Board board) {
        int counter = 0;
        for(int i = 0; i < board.numRows; i++) {
            for(int j = 0; j < board.numCols; j++) {
                GridPane.setConstraints(board.tiles.get(counter),
                        j, i);
                gridPane.getChildren().add(board.tiles.get(counter));
                counter++;
            }
        }
    }
}