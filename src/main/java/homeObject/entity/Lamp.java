package homeObject.entity;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;

public class Lamp extends HomeObjectEntity {
    private static int lampId = 0;
    private double lumens;

    public Lamp() throws IOException {
        super("Lamp" + ++lampId, "lamp_view.fxml");
        this.lumens = 0;
    }

    @Override
    public void create() {
        Image icon = new Image("images/lamp.png");
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
    public void notifyChange() {
    }

    public void setLumens(double lumens){
        this.lumens = lumens;
    }
}
