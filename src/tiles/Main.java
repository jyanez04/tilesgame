package tiles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Tiles!");
        Board gameBoard = new Board();
        gameBoard.init();
        Display display = new Display();
        display.drawBoard(gameBoard);

        primaryStage.setScene(new Scene(display.getGridPane(), 1500,
                700, Color.BLACK));
        primaryStage.show();

    }
}
