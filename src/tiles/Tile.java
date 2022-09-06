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
    public static int playerScore = 0;
    public static int playerCombo = 0;
    public static int longestCombo = 0;

    public Tile() {
        this.components = new ArrayList<>();

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            selections.add(this);
            if(selections.size() == 2) {
                if(matchTiles(selections)) {
                    Display.scoreBoard.setText("Score: " + ++playerScore);
                    Display.combo.setText("Current combo: " + ++playerCombo);
                    if(playerCombo >= longestCombo) {
                        longestCombo = playerCombo;
                        Display.longestCombo.setText("Longest combo: " + longestCombo);
                    }
                } else {
                    playerCombo = 0;
                    Display.combo.setText("Current combo: " + playerCombo);
                }
            }
        } );
    }

    public static boolean matchTiles(ArrayList<Tile> selections) {
        boolean matched = false;
        Tile selectedTile = selections.get(0);
        Tile targetTile = selections.get(1);
        for(int i = 0; i < selectedTile.getChildren().size(); i++) {
            if(selectedTile.getComponents().get(i).getFill().equals(Color.TRANSPARENT) ||
            targetTile.getComponents().get(i).getFill().equals(Color.TRANSPARENT)) {
                matched = false;
            } else if(selectedTile.getComponents().get(i).getFill().
                    equals(targetTile.getComponents().get(i).getFill())) {
                selectedTile.getComponents().get(i).setFill(Color.TRANSPARENT);
                targetTile.getComponents().get(i).setFill(Color.TRANSPARENT);
                matched = true;
            }
        }
        selections.clear();
        return matched;
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
