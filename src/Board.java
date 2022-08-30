import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board {

    public ArrayList<Group> tiles;
    public ArrayList<Color> colorPalette = new ArrayList<>();
    public int numRows = 5;
    public int numCols = 6;

    public Board() {
        this.tiles = new ArrayList<>();
    }

    public void init() {
        colorPalette.add(Color.rgb(205, 210, 203));
        colorPalette.add(Color.rgb(126, 147, 146));
        colorPalette.add(Color.rgb(165, 160, 156));
        colorPalette.add(Color.rgb(203, 145, 144));

        for(int i = 0; i < (numRows*numCols); i++) {
            Group tile = new Group();
            Rectangle rect = new Rectangle(
                    100,
                    100,
                    Color.rgb(205, 210, 203));

            Polygon dia = new Polygon();
            dia.getPoints().addAll(
                    rect.getWidth()/2, 0.0,
                    0.0, rect.getHeight()/2,
                    rect.getWidth()/2, rect.getHeight(),
                    rect.getWidth(), rect.getHeight()/2);
            dia.setFill(Color.rgb(126, 147, 146));

            Circle circle = new Circle(
                    rect.getWidth()/2,
                    rect.getHeight()/2,
                    rect.getWidth()/5,
                    Color.rgb(203, 145, 144));

            tile.getChildren().addAll(rect, dia, circle);
            tiles.add(tile);
        }
    }
}
