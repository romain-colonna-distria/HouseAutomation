package controller;

import homeObject.entity.HomeObjectEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class HomeObjectEntityController implements HomeObjectController {
    @FXML
    private Label nameObjectLabel;
    @FXML
    private Label nameParentLabel;
    @FXML
    private Pane infosPane;

    public void init(HomeObjectEntity objectEntity){
        String nameObject = objectEntity.getName();
        String nameParent = objectEntity.getRoot().getName();

        nameObjectLabel.setText(nameObject);
        nameParentLabel.setText(nameParent);

        objectEntity.getController().init(objectEntity);

        this.infosPane.getChildren().add(objectEntity.getPane());
    }
}
