package homeObject.entity;


import controller.HomeObjectController;
import homeObject.HomeObject;
import homeObject.complex.Field;
import homeObject.complex.HomeObjectComplex;
import homeObject.observer.Observer;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class HomeObjectEntity extends ImageView implements HomeObject, Observer {
    private String name;
    private HomeObjectComplex root;

    private FXMLLoader loader;
    private Pane pane;


    public HomeObjectEntity(String name, String namefileView) throws IOException {
        super();
        this.name = name;

        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getResource("../../fxml/" + namefileView));
        pane = this.loader.load();
    }

    @Override
    public void draw(Field areaDrawingHouse, boolean isFinalShape) {
        areaDrawingHouse.getChildren().remove(this);
        create();
        areaDrawingHouse.getChildren().add(this);
    }

    public HomeObjectComplex getRoot() {
        return root;
    }

    public void setRoot(HomeObjectComplex root) {
        this.root = root;
    }

    public void setCoordinates(double x, double y){
        setX(x);
        setY(y);
    }

    public String getName() {
        return name;
    }

    public HomeObjectController getController(){
        return loader.getController();
    }

    public Pane getPane(){
        return pane;
    }
}
