package homeObject.complex;

import homeObject.HomeObject;
import homeObject.entity.Lamp;
import homeObject.observer.Observable;
import homeObject.observer.Observer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

public abstract class HomeObjectComplex extends Polygon implements HomeObject, Observable {
    private String name;
    private List<HomeObject> objects = new ArrayList<>();

    private double temperature = 0;
    private double humidityLevel = 0;
    private double lumens = 0;

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

    @Override
    public void notifyChange() {
        for(HomeObject object : objects){
            if(!(object instanceof Observer)) continue;
            ((Observer) object).notifyChange();
        }
    }

    public void addObject(HomeObject newObject){
        objects.add(newObject);
    }

    public void removeObject(HomeObject object){
        objects.remove(object);
    }

    public void increasesTemperature(){
        ++this.temperature;
    }

    public void decreasesTemperature(){
        --this.temperature;
    }

    public void setOnMovingColor(){
        setStroke(Color.AQUA);
        setFill(Color.AQUA);
    }

    public abstract void setOnFinalColor();

    public String getName() {
        return name;
    }
    public List<HomeObject> getObjects(){
        return objects;
    }
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidityLevel() {
        return humidityLevel;
    }
    public double getLumens() {
        return lumens;
    }
    public void addLumens(double lumens){
        this.lumens += lumens;
    }
}
