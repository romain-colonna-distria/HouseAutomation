package homeObject.simple;

import homeObject.HomeObject;
import homeObject.complex.Field;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;


public abstract class HomeObjectSimple extends Path implements HomeObject {
    private String name;
    private HomeObject source;

    private double x;
    private double y;
    private double width;
    private double height;

    public HomeObjectSimple(String name){
        super();
        this.name = name;
    }


    @Override
    public void draw(Field areaDrawingHouse, boolean isFinalShape) {
        areaDrawingHouse.getChildren().remove(this);
        create();
        if (isFinalShape) setOnFinalColor();
        else setOnMovingColor();
        areaDrawingHouse.getChildren().add(this);
    }

    public String getName() {
        return name;
    }

    public void setSourceObject(HomeObject source){
        this.source = source;
    }

    public HomeObject getSourceObject() {
        return source;
    }

    public void setOnMovingColor(){
        setStroke(Color.AQUA);
    }

    public abstract void setOnFinalColor();

    public double getSize(){
        return getWidth() > getHeight() ? getWidth() : getHeight();
    }

    public void setStartPoints(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setDimensions(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "HomeObjectSimple{" +
                "name='" + name + '\'' +
                ", source=" + source +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
