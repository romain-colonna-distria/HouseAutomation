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
            System.out.println("Entré");
            if(expectedTemperatureTextField.getText().isEmpty()) return;
            double expectedTemp = Double.valueOf(expectedTemperatureTextField.getText());
            double actuelTemp = entity.getRoot().getTemperature();
            if(expectedTemp >= actuelTemp) return;

            while (expectedTemp != actuelTemp){
                expectedTemp = Double.valueOf(expectedTemperatureTextField.getText());
                actuelTemp = entity.getRoot().getTemperature();

                if (expectedTemp < actuelTemp){
                    entity.getRoot().decreasesTemperature();
                    entity.getRoot().notifyChange();
                }
                System.out.println("Temp: " + entity.getRoot().getTemperature());


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    @Override
    public void init(HomeObjectEntity objectEntity) {
        this.entity = objectEntity;
        expectedTemperatureTextField.setOnAction(onExpectedTemperatureChange);
    }
}
