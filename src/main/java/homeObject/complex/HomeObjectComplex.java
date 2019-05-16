package homeObject.complex;

import homeObject.HomeObject;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public abstract class HomeObjectComplex extends Polygon implements HomeObject {
    private String name;
    private List<HomeObject> objects = new ArrayList<>();

    private double temperature;
    private double humidityLevel;
    private double brightnessLevel;

    public HomeObjectComplex(String name){
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

    public void addObject(HomeObject newObject){
        objects.add(newObject);
    }

    public void removeObject(HomeObject object){
        objects.remove(object);
    }

    public List<HomeObject> getObjects(){
        return objects;
    }

    public void setOnMovingColor(){
        setStroke(Color.AQUA);
        setFill(Color.AQUA);
    }

    public abstract void setOnFinalColor();

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidityLevel() {
        return humidityLevel;
    }

    public double getBrightnessLevel() {
        return brightnessLevel;
    }


}
