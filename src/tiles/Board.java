package tiles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {

    private ArrayList<Tile> tiles;
    private double tileSize = 100;
    private int numRows = 5;
    private int numCols = 6;
    private int size = numRows*numCols;

    // color palettes to be used by the components of each tile
    private ArrayList<Color> rectPalette = new ArrayList<>();
    private ArrayList<Color> diamondPalette = new ArrayList<>();
    private ArrayList<Color> circlePalette = new ArrayList<>();

    private Random rand = new Random();

    public Board() {
        tiles = new ArrayList<>();

        rectPalette.add(Color.rgb(205, 210, 203));
        rectPalette.add(Color.rgb(126, 147, 166));
        rectPalette.add(Color.rgb(95, 76, 117));
        rectPalette.add(Color.rgb(87, 76, 78));

        diamondPalette.add(Color.rgb(78, 107, 76));
        diamondPalette.add(Color.rgb(173, 98, 0));
        diamondPalette.add(Color.rgb(44, 66, 143));

        circlePalette.add(Color.rgb(125, 44, 44));
        circlePalette.add(Color.rgb(67, 4, 176));
        circlePalette.add(Color.rgb(38, 99, 94));
    }

    /**
     * This method initializes the game board by generating even amounts
     * of components that share the same color. This way, each component of
     * each tile can be matched with another component from a different tile.
     * This algorithm ensures the board can be cleared in one unbroken streak.
     */
    public void init() {
        for(int i = 0; i < size; i++) {
            Tile newTile = new Tile();
            tiles.add(newTile);
        }

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        ArrayList<Polygon> diamonds = new ArrayList<>();
        ArrayList<Circle> circles = new ArrayList<>();

        for(int i = 0; i < size/2; i++) {
            Rectangle newRect = new Rectangle(
                100,
                100,
                 rectPalette.get(rand.nextInt(rectPalette.size())));
            Rectangle dupeRect = new Rectangle(
                100,
                100,
                newRect.getFill());
            rectangles.add(newRect);
            rectangles.add(dupeRect);
        }
        Collections.shuffle(rectangles);

        for(int i = 0; i < rectangles.size(); i++) {
            tiles.get(i).getChildren().add(rectangles.get(i));
            tiles.get(i).getComponents().add(rectangles.get(i));
        }

        for(int i = 0; i < size/2; i++) {
            Polygon newDia = new Polygon();
            newDia.getPoints().addAll(
                    tileSize/2, 0.0,
                    0.0, tileSize/2,
                    tileSize/2, tileSize,
                    tileSize, tileSize/2);
            newDia.setFill(diamondPalette.get(rand.nextInt(diamondPalette.size())));

            Polygon dupeDia = new Polygon();
            dupeDia.getPoints().addAll(
                    tileSize/2, 0.0,
                    0.0, tileSize/2,
                    tileSize/2, tileSize,
                    tileSize, tileSize/2);
            dupeDia.setFill(newDia.getFill());
            diamonds.add(newDia);
            diamonds.add(dupeDia);
        }
        Collections.shuffle(diamonds);

        for(int i = 0; i < diamonds.size(); i++) {
            tiles.get(i).getChildren().add(diamonds.get(i));
            tiles.get(i).getComponents().add(diamonds.get(i));
        }

        for(int i = 0; i < size/2; i++) {
            Circle newCirc = new Circle(
                    tileSize/2,
                    tileSize/2,
                    tileSize/5,
                    circlePalette.get(rand.nextInt(circlePalette.size())));
            Circle dupeCirc = new Circle(
                    tileSize/2,
                    tileSize/2,
                    tileSize/5,
                    newCirc.getFill());
            circles.add(newCirc);
            circles.add(dupeCirc);
        }
        Collections.shuffle(circles);
        for(int i = 0; i < circles.size(); i++) {
            tiles.get(i).getChildren().add(circles.get(i));
            tiles.get(i).getComponents().add(circles.get(i));
        }
        Collections.shuffle(tiles);
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
