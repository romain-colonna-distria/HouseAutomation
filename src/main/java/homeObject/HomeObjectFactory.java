package homeObject;

import homeObject.complex.Room;
import homeObject.entity.AirConditioner;
import homeObject.entity.Radiator;
import homeObject.entity.Thermometer;
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
            case "ThermometerButton":
                return new Thermometer();
            case "RadiatorButton":
                return new Radiator();
            case "AirConditionerButton":
                return new AirConditioner();
            default:
                return null;
        }
    }
}
