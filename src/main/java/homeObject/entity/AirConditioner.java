package homeObject.entity;

import javafx.scene.image.Image;

import java.io.IOException;

public class AirConditioner extends HomeObjectEntity {
    private static int airConditionerId = 0;

    public AirConditioner() throws IOException {
        super("AirConditioner" + ++airConditionerId, "air_conditioner_view.fxml");
    }

    @Override
    public void create() {
        Image icon = new Image("images/airConditioner.png");
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
