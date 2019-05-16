package homeObject.adapter;

import homeObject.entity.HomeObjectEntity;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public abstract class HomeObjectEntityAdapter extends AnchorPane{
    private HomeObjectEntity homeEntity;

    public HomeObjectEntityAdapter(HomeObjectEntity homeEntity){
        this.homeEntity = homeEntity;
    }

    public abstract Pane getPane();

    public HomeObjectEntity getHomeEntity(){
        return homeEntity;
    }
}
