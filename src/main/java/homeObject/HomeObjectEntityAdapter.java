package homeObject;

import controller.HomeObjectEntityController;
import homeObject.entity.HomeObjectEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class HomeObjectEntityAdapter extends AnchorPane {
    private HomeObjectEntity homeEntity;

    public HomeObjectEntityAdapter(HomeObjectEntity homeEntity){
        this.homeEntity = homeEntity;
    }

    public Pane getPane(){
        FXMLLoader rootPaneFxmlLoader = new FXMLLoader();
        rootPaneFxmlLoader.setLocation(getClass().getResource("../fxml/home_object_entity_view.fxml"));

        AnchorPane pane = null;
        try {
            pane = rootPaneFxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HomeObjectEntityController controller = rootPaneFxmlLoader.getController();
        controller.init(homeEntity);

        return pane;
    }
}
