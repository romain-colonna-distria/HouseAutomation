package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HomeObjectEntityController {
    @FXML
    private Label nameObjectLabel;
    @FXML
    private Label nameParentLabel;
    @FXML
    private Pane infosPane;

    public void init(String nameObject, String nameParent, Pane infosPane){
        nameObjectLabel.setText(nameObject);
        nameParentLabel.setText(nameParent);
        this.infosPane.getChildren().add(infosPane);
    }
}
