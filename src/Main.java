import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tiles!");
        Display display = new Display();

        primaryStage.setScene(new Scene(display.gridPane, 300, 500));
        primaryStage.show();

    }
}
