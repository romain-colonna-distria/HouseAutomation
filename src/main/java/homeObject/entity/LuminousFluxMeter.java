package homeObject.entity;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;

public class LuminousFluxMeter extends HomeObjectEntity {
    private static int luminousFluxId;

    public LuminousFluxMeter() throws IOException {
        super("LuminousFluxMeter" + ++luminousFluxId, "luminous_flux_meter_view.fxml");
    }

    @Override
    public void create() {
        Image icon = new Image("images/luminousFluxMeter.png");
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
        ((Label)getPane().getChildren().get(1)).setText(String.valueOf(getRoot().getLumens()));
    }
}
