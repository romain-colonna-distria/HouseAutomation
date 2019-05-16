package homeObject.entity;

import homeObject.HomeObject;
import homeObject.complex.Field;
import homeObject.complex.HomeObjectComplex;
import javafx.scene.image.ImageView;

public abstract class HomeObjectEntity extends ImageView implements HomeObject {
    private String name;
    private HomeObjectComplex root;


    public HomeObjectEntity(String name){
        super();
        this.name = name;
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
}
