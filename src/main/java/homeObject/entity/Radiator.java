package homeObject.entity;

import javafx.scene.image.Image;

import java.io.IOException;


public class Radiator extends HomeObjectEntity {
    private static int radiatorId = 0;


    public Radiator() throws IOException {
        super("Radiator" + ++radiatorId, "radiator_view.fxml");
    }

    @Override
    public void create() {
        Image icon = new Image("images/radiator.png");
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
}
