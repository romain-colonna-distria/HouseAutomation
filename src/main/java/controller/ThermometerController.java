package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ThermometerController {
    @FXML
    private Label temperatureLabel;

    public void init(String temperature){
        temperatureLabel.setText(temperature);
    }
}
