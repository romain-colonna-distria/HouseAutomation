package homeObject.entity;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;


public class Thermometer extends HomeObjectEntity {
    private static int thermometerId = 0;


    public Thermometer() throws IOException {
        super("Thermometer" + ++thermometerId, "thermometer_view.fxml");
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
        return getRoot() != null;
    }

    @Override
    public synchronized void notifyChange() {
        ((Label)getPane().getChildren().get(1)).setText(String.valueOf(getRoot().getTemperature()));
    }
}
