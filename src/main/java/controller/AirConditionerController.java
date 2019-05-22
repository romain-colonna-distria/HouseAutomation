package controller;

import homeObject.entity.HomeObjectEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AirConditionerController implements HomeObjectController {
    @FXML
    private TextField expectedTemperatureTextField;

    private HomeObjectEntity entity;


    private EventHandler<ActionEvent> onExpectedTemperatureChange = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(expectedTemperatureTextField.getText().isEmpty()) return;
            double expectedTemp = Double.valueOf(expectedTemperatureTextField.getText());
            double actuelTemp = entity.getRoot().getTemperature();
            if(expectedTemp >= actuelTemp) return;

            if (expectedTemp < actuelTemp){
                entity.getRoot().setTemperature(expectedTemp);
                entity.getRoot().notifyChange();
            }
        }
    };


    @Override
    public void init(HomeObjectEntity objectEntity) {
        this.entity = objectEntity;
        expectedTemperatureTextField.setOnAction(onExpectedTemperatureChange);
    }
}
