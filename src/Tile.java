import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Tile extends Node {

    Rectangle background;
    Rectangle diamond;
    Circle bullseye;

    public Tile() {
        this.background = new Rectangle();
        this.diamond = new Rectangle();
        this.bullseye = new Circle(5, Color.RED);

        this.background.setHeight(50.0);
        this.background.setWidth(50.0);
        this.background.setFill(Color.BLUE);

        this.diamond.setHeight(50.0);
        this.diamond.setWidth(50.0);
        this.diamond.setFill(Color.WHITE);
    }
}
