import javafx.scene.Group;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Display {

    GridPane gridPane;

    public Display() {
        this.gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setVgap(7.5);
        gridPane.setHgap(7.5);
    }
    public void drawBoard(ArrayList<Group> board) {
        int i = 0;
        int row = 0;
        int col = 0;
        for(Group tile : board) {
            if(col % 6 == 0) {
                row++;
                col = 0;
                GridPane.setConstraints(tile, col, row);
            } else {
                GridPane.setConstraints(tile, col, row);
            }
            gridPane.getChildren().add(tile);
            col++;
        }
    }
}