package tiles;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Tile extends Group {

    private ArrayList<Shape> components;
    private static ArrayList<Tile> selections = new ArrayList<>();

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
                        Display.longestCombo.setText
                                ("Longest combo: " + longestCombo);
                    }
                } else {
                    playerCombo = 0;
                    Display.combo.setText("Current combo: " + playerCombo);
                }
            }
        } );
    }

    /**
     * This method takes a list of 2 tiles and sees if they have any matching
     * components. If so, the method "removes" the components from both tiles
     * (in other words, makes the components transparent).
     * @param selections the list containing the 2 tiles to be compared
     * @return true if any components matched, false if not
     */
    public static boolean matchTiles(ArrayList<Tile> selections) {
        boolean matched = false;
        Tile selectedTile = selections.get(0);
        Tile targetTile = selections.get(1);
        for(int i = 0; i < selectedTile.getChildren().size(); i++) {
            if(selectedTile
                    .components.get(i).getFill().equals(Color.TRANSPARENT) ||
                    targetTile
                    .components.get(i).getFill().equals(Color.TRANSPARENT)) {
                continue;
            } else if(selectedTile.components.get(i).getFill().
                    equals(targetTile.components.get(i).getFill())) {
                selectedTile.components.get(i).setFill(Color.TRANSPARENT);
                targetTile.components.get(i).setFill(Color.TRANSPARENT);
                matched = true;
            }
        }
        selections.clear();
        return matched;
    }

    public ArrayList<Shape> getComponents() {
        return components;
    }
}
