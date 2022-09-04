package tiles;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Tile extends Group {

    public ArrayList<Color> colorPalette = new ArrayList<>();
    private Group components;
    private Rectangle rect;
    private Polygon dia;
    private Circle circle;
    public static ArrayList<Group> selections = new ArrayList<>();
    private boolean isCleared;
    boolean isSelected;

    public Tile() {
        isSelected = false;

        this.components = new Group();
        this.components.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            selections.add(this.components);
            if(selections.size() == 2) {
                matchTiles(selections);
            } else {
                this.isSelected = true;

            }
        } );
    }

    public static void matchTiles(ArrayList<Group> selections) {
        System.out.println("entered function");
        Group selectedTile = selections.get(0);
        Group targetTile = selections.get(1);
        for(int i = 0; i < selectedTile.getChildren().size(); i++) {
            if(selectedTile.getChildren().get(i).equals(targetTile.getChildren().get(i))) {
                selectedTile.getChildren().remove(i);
                targetTile.getChildren().remove(i);
            }
        }
        selections.clear();
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
