import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Tile extends Group {

    public ArrayList<Color> colorPalette = new ArrayList<>();
    private Group components;
    private Rectangle rect;
    private Polygon dia;
    private Circle circle;
    private boolean isCleared;

    public Tile(Color rectColor, Color diaColor, Color circColor) {

        this.components = new Group();
        this.rect = new Rectangle(
                100,
                100,
                rectColor);

        this.dia = new Polygon();
        dia.getPoints().addAll(
                rect.getWidth()/2, 0.0,
                0.0, rect.getHeight()/2,
                rect.getWidth()/2, rect.getHeight(),
                rect.getWidth(), rect.getHeight()/2);
        this.dia.setFill(diaColor);

        this.circle = new Circle(
                rect.getWidth()/2,
                rect.getHeight()/2,
                rect.getWidth()/5,
                circColor);



        components.getChildren().addAll(rect, dia, circle);
    }

    public Rectangle getRect() {
        return rect;
    }

    public Polygon getDia() {
        return dia;
    }

    public Circle getCircle() {
        return circle;
    }

    public Group getComponents() {
        return components;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
