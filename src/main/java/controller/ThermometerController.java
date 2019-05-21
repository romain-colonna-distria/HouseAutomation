package controller;

import homeObject.entity.HomeObjectEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ThermometerController implements HomeObjectController {
    @FXML
    private Label temperatureLabel;

    @Override
    public void init(HomeObjectEntity objectEntity){
        String temperature = String.valueOf(objectEntity.getRoot().getTemperature());
        temperatureLabel.setText(temperature);
    }
}
