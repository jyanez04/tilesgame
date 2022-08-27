import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class Display {

    TilePane tilePane;

    public Display() {
        this.tilePane = new TilePane(5.0, 5.0);
        for (int i = 0; i < 30; i++) {
            Canvas canvas = new Canvas(100.0, 100.0);
            GraphicsContext gc = canvas.getGraphicsContext2D();

            gc.setFill(Color.BLUE);
            gc.fillRect(gc.getCanvas().getLayoutX(),
                    gc.getCanvas().getLayoutY(),
                    gc.getCanvas().getWidth(),
                    gc.getCanvas().getHeight());
            tilePane.getChildren().add(canvas);
        }
        System.out.println(tilePane.getChildren());
    }

}