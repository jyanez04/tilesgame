import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class Display {

    TilePane tilePane;
    GridPane gridPane;

    public Display() {
        this.gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setVgap(5.0);
        gridPane.setHgap(5.0);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 6; j++) {
                Canvas canvas = new Canvas(100.0, 100.0);
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.BLUE);
                gc.fillRect(gc.getCanvas().getLayoutX(),
                        gc.getCanvas().getLayoutY(),
                        gc.getCanvas().getWidth(),
                        gc.getCanvas().getHeight());
                gc.setFill(Color.WHITE);
                gc.fillOval(gc.getCanvas().getLayoutX() + canvas.getWidth()/4,
                        gc.getCanvas().getLayoutY() + canvas.getHeight()/4,
                        gc.getCanvas().getWidth()/2,
                        gc.getCanvas().getHeight()/2);
                GridPane.setConstraints(canvas, j, i);
                gridPane.getChildren().add(canvas);
            }
        }

//        this.tilePane = new TilePane(5.0, 5.0);
//        for (int i = 0; i < 30; i++) {
//            Canvas canvas = new Canvas(100.0, 100.0);
//            GraphicsContext gc = canvas.getGraphicsContext2D();
//
//            gc.setFill(Color.BLUE);
//            gc.fillRect(gc.getCanvas().getLayoutX(),
//                    gc.getCanvas().getLayoutY(),
//                    gc.getCanvas().getWidth(),
//                    gc.getCanvas().getHeight());
//            tilePane.getChildren().add(canvas);
//        }
//        System.out.println(tilePane.getChildren());
    }

}