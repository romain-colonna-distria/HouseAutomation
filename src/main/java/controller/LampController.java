package controller;

import homeObject.entity.HomeObjectEntity;
import homeObject.entity.Lamp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LampController implements HomeObjectController {
    @FXML
    private TextField expectedLumensTextField;

    private HomeObjectEntity entity;


    private EventHandler<ActionEvent> onExpectedTemperatureChange = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(expectedLumensTextField.getText().isEmpty()) return;
            double lumens = Double.valueOf(expectedLumensTextField.getText());

            ((Lamp)entity).setLumens(lumens);
            entity.getRoot().addLumens(lumens);
            entity.getRoot().notifyChange();
            System.out.println("Flux lumineux de la lampe " + entity.getName() + " mis a jour.");
        }
    };


    @Override
    public void init(HomeObjectEntity objectEntity) {
        this.entity = objectEntity;
        expectedLumensTextField.setOnAction(onExpectedTemperatureChange);
    }
}
