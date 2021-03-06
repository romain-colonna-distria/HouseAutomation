package controller;

import homeObject.entity.HomeObjectEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class RadiatorController implements HomeObjectController {
    @FXML
    private TextField expectedTemperatureTextField;

    private HomeObjectEntity entity;


    private EventHandler<ActionEvent> onExpectedTemperatureChange = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(expectedTemperatureTextField.getText().isEmpty()) return;
            double expectedTemp = Double.valueOf(expectedTemperatureTextField.getText());
            double actuelTemp = entity.getRoot().getTemperature();
            if(expectedTemp <= actuelTemp) return;

            entity.getRoot().setTemperature(expectedTemp);
            entity.getRoot().notifyChange();

            /*
            while (expectedTemp != actuelTemp){
                expectedTemp = Double.valueOf(expectedTemperatureTextField.getText());
                actuelTemp = entity.getRoot().getTemperature();

                if (expectedTemp > actuelTemp){
                    entity.getRoot().increasesTemperature();
                    entity.getRoot().notifyChange();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            */
            System.out.println("Température de la pièce " + entity.getRoot().getName() + " mis a jour.");
        }
    };


    @Override
    public void init(HomeObjectEntity objectEntity) {
        this.entity = objectEntity;
        expectedTemperatureTextField.setOnAction(onExpectedTemperatureChange);
    }
}
