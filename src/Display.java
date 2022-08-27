import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Display {

    GridPane gridPane;

    public Display() {
        this.gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Button button = new Button("test");
        GridPane.setRowIndex(button, 0);
        GridPane.setColumnIndex(button, 1);
        gridPane.getChildren().addAll(button);
    }

}