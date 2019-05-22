package homeObject;

import homeObject.complex.Room;
import homeObject.entity.*;
import homeObject.simple.Door;
import homeObject.simple.Wall;
import homeObject.simple.Window;

import java.io.IOException;

public class HomeObjectFactory {
    public static HomeObject getHomeObject(String homeObjectName) throws IOException {
        switch (homeObjectName){
            case "roomButton":
                return new Room();
            case "wallButton":
                return new Wall();
            case "doorButton":
                return new Door();
            case "windowButton":
                return new Window();
            case "thermometerButton":
                return new Thermometer();
            case "radiatorButton":
                return new Radiator();
            case "airConditionerButton":
                return new AirConditioner();
            case "lampButton":
                return new Lamp();
            case "luminousFluxMeterButton":
                return new LuminousFluxMeter();
            default:
                return null;
        }
    }
}
