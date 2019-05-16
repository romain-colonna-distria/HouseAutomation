package homeObject.adapter;

import controller.HomeObjectEntityController;
import controller.ThermometerController;
import homeObject.entity.HomeObjectEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ThermometerAdapter extends HomeObjectEntityAdapter {

    public ThermometerAdapter(HomeObjectEntity homeEntity) {
        super(homeEntity);
    }

    @Override
    public AnchorPane getPane() {
        FXMLLoader rootPaneFxmlLoader = new FXMLLoader();
        rootPaneFxmlLoader.setLocation(getClass().getResource("../../fxml/home_object_entity_view.fxml"));
        FXMLLoader infosPaneFxmlLoader = new FXMLLoader();
        infosPaneFxmlLoader.setLocation(getClass().getResource("../../fxml/thermometer_view.fxml"));

        AnchorPane pane = null;
        Pane infosPane = null;
        try {
            pane = rootPaneFxmlLoader.load();
            infosPane = infosPaneFxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ThermometerController thermometerController = infosPaneFxmlLoader.getController();
        thermometerController.init(String.valueOf(getHomeEntity().getRoot().getTemperature())); //TODO: initialise temperature mais ne la met pas a jour

        String nameObject = getHomeEntity().getName();
        String nameParent = getHomeEntity().getRoot().getName();


        HomeObjectEntityController controller = rootPaneFxmlLoader.getController();
        controller.init(nameObject, nameParent, infosPane);

        return pane;
    }
}
