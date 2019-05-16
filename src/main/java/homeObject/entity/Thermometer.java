package homeObject.entity;

import javafx.scene.image.Image;

public class Thermometer extends HomeObjectEntity {
    private static int thermometerId = 0;

    public Thermometer(){
        super("Thermometer" + ++thermometerId);

    }

    @Override
    public void create() {
        Image icon = new Image("images/temperature.png");
        setImage(icon);
        setFitWidth(15);
        setFitHeight(15);
        getRoot().addObject(this);
    }

    @Override
    public boolean isDrawable() {
        return true;
    }

    //@Override
    public void executeFunction() {
        getRoot().getTemperature();
    }
}
