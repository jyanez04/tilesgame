import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    public ArrayList<Tile> tiles;
    public ArrayList<Color> colorPalette = new ArrayList<>();
    public int numRows = 5;
    public int numCols = 6;
    Random rand = new Random();

    public Board() {
        this.tiles = new ArrayList<>();
    }

    public void init() {
        colorPalette.add(Color.rgb(205, 210, 203));
        colorPalette.add(Color.rgb(126, 147, 146));
        colorPalette.add(Color.rgb(165, 160, 156));
        colorPalette.add(Color.rgb(203, 145, 144));
        colorPalette.add(Color.rgb(87, 76, 78));

        for(int i = 0; i < (numRows*numCols); i++) {
            Tile newTile = new Tile(colorPalette.get(rand.nextInt(colorPalette.size())),
                    colorPalette.get(rand.nextInt(colorPalette.size())),
                    colorPalette.get(rand.nextInt(colorPalette.size())));
            tiles.add(newTile);
        }
    }
}
