import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board {

    ArrayList<Group> tileBoard;

    public Board() {
        this.tileBoard = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            Group tile = new Group();
            Rectangle rect = new Rectangle();
            rect.setWidth(100);
            rect.setHeight(100);
            rect.setFill(Color.BLUE);

            Circle circle = new Circle();
            circle.setCenterX(50);
            circle.setCenterY(50);
            circle.setRadius(25);
            circle.setFill(Color.WHITE);

            tile.getChildren().addAll(rect, circle);
            tileBoard.add(tile);
        }
        System.out.println(tileBoard);
    }

    public static void main(String[] args) {
        Board board = new Board();
    }
}
