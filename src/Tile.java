import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import javax.crypto.spec.PSource;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Tile extends Group {

    public ArrayList<Color> colorPalette = new ArrayList<>();
    private Group components;
    private Rectangle rect;
    private Polygon dia;
    private Circle circle;
    private boolean isCleared;
    boolean isSelected;

    public Tile() {
        isSelected = false;

        this.components = new Group();
        this.components.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println(isSelected);
            isSelected = true;
            System.out.println(isSelected);
        } );
    }

    public void matchTiles(Tile selectedTile, Tile targetTile) {
        for(int i = 0; i < selectedTile.getComponents().getChildren().size(); i++) {
            if(selectedTile.getComponents().getChildren().get(i).
            equals(targetTile.getComponents().getChildren().get(i))) {
                selectedTile.getComponents().getChildren().remove(i);
                targetTile.getComponents().getChildren().remove(i);
            }
        }
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
