package tiles;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Tile extends Group {

    private ArrayList<Shape> components;
    public static ArrayList<Tile> selections = new ArrayList<>();
    private boolean isCleared;
    boolean isSelected;

    public Tile() {
        isSelected = false;
        this.components = new ArrayList<>();

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            selections.add(this);
            if(selections.size() == 2) {
                matchTiles(selections);
            } else {
                this.isSelected = true;

            }
        } );
    }

    public static void matchTiles(ArrayList<Tile> selections) {
        System.out.println("entered function");
        Tile selectedTile = selections.get(0);
        Tile targetTile = selections.get(1);
        for(int i = 0; i < selectedTile.getChildren().size(); i++) {
            if(selectedTile.getComponents().get(i).getFill().
                    equals(targetTile.getComponents().get(i).getFill())) {
                selectedTile.getComponents().get(i).setFill(Color.TRANSPARENT);
                targetTile.getComponents().get(i).setFill(Color.TRANSPARENT);
            }
        }
        selections.clear();
    }

    public ArrayList<Shape> getComponents() {
        return components;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public void setCleared(boolean cleared) {
        isCleared = cleared;
    }
}
