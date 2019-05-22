package controller;

import homeObject.entity.HomeObjectEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LuminousFluxMeterController implements HomeObjectController {
    @FXML
    private Label luminousFluxMeterLabel;

    @Override
    public void init(HomeObjectEntity objectEntity){
        String lumens = String.valueOf(objectEntity.getRoot().getLumens());
        luminousFluxMeterLabel.setText(lumens);
    }
}
