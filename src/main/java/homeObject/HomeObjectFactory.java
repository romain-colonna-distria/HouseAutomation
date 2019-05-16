package homeObject;

import homeObject.complex.Room;
import homeObject.entity.Thermometer;
import homeObject.simple.Door;
import homeObject.simple.Wall;
import homeObject.simple.Window;

public class HomeObjectFactory {
    public static HomeObject getHomeObejct(String homeObjectName) {
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
            default:
                return null;
        }
    }
}
