package homeObject.complex;

import homeObject.simple.Wall;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Room extends HomeObjectComplex {
    private static int roomId = 0;
    private List<Wall> walls;

    public Room(){
        super("Room" + ++roomId);
        walls = new ArrayList<>();
    }

    public void addWall(Wall newWall){
        walls.add(newWall);
    }

    @Override
    public boolean isDrawable() {
        return true;
    }

    @Override
    public void create() {
        if(walls.size() < 3) return; //minimum 3 mur pour une pièce
        getPoints().clear();
        Double[] points = new Double[walls.size() * 2];
        double x;
        double y;

        Shape tempShape;
        double minXFirst = walls.get(0).getX();
        for(Wall wall : walls){
            if(wall.getX() < minXFirst) minXFirst = wall.getX();
        }

        /* récupère le plus petit x pour faire la diff avec celui de la forme de base */
        double minXLast = Shape.intersect(walls.get(0), walls.get(1)).getBoundsInLocal().getMinX();
        /*
        for(int i = 0; i < walls.size(); ++i) {
            tempShape = Shape.intersect(walls.get(i), ((i + 1) == walls.size() ? walls.get(0) : walls.get(i + 1)));
            if (tempShape.getBoundsInLocal().getMinX() < minXLast) minXLast = tempShape.getBoundsInLocal().getMinX();
        }
        */

        double diff = minXLast - minXFirst;

        int j = 0;
        for(int i = 0; i < walls.size(); ++i){
            tempShape = Shape.intersect(walls.get(i), ((i + 1) == walls.size() ? walls.get(0) : walls.get(i + 1)));

            x = tempShape.getBoundsInLocal().getMinX() - diff;
            y = tempShape.getBoundsInLocal().getMinY() - 3;

            points[j] = x;
            points[j+1] = y;

            j += 2;
        }

        getPoints().addAll(points);
    }

    @Override
    public void draw(Field areaDrawingHouse, boolean isFinalShape) {
        areaDrawingHouse.getChildren().remove(this);
        create();
        if (isFinalShape) setOnFinalColor();
        else setOnMovingColor();
        areaDrawingHouse.getChildren().add(this);
    }

    @Override
    public void setOnFinalColor(){
        setStroke(Color.WHITE);
        setFill(Color.BEIGE);
    }

    public List<Wall> getWalls() {
        return walls;
    }

    @Override
    public String toString() {
        return "Room{" +
                "walls=" + walls +
                '}';
    }


}


/*
                x = tempShape.getBoundsInLocal().getMinX() - (tempShape.getBoundsInLocal().getMinX() - minX);// - (tempShape.getBoundsInParent().getMinX() - firstx);// - (3 * firstx);// - (tempShape.getBoundsInParent().getMinX() - firstx);
                y = tempShape.getBoundsInLocal().getMinY() - 3; //tempShape.getLayoutBounds().getMinY() - 3;
 */