package homeObject.simple;

import homeObject.HomeObject;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;


public class Wall extends HomeObjectSimple {
    private static int wallId = 0;

    private Set<Wall> intersectWalls;

    private boolean isHorizontal;

    private HomeObject destination;

    public Wall() {
        super("Wall" + ++wallId);

        intersectWalls = new HashSet<>();
        setStrokeWidth(8);


    }

    @Override
    public void create(){
        getElements().clear();
        if(getWidth() > getHeight()) {
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX(), getY() + getWidth() - (getWidth() < 5 ? getWidth() : 5))); //le ternnaire permet de décaler le trait du mur de la sourie
            isHorizontal = true;
        } else {
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX() + getHeight() - (getHeight() < 5 ? getHeight() : 5), getY()));
            isHorizontal = false;
        }


        setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                onMouseEvent(event);
            }
        });

        setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                setStrokeWidth(8);
            }
        });


        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onMouseEvent(event);
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setStrokeWidth(8);
            }
        });
    }

    private void onMouseEvent(MouseEvent event){
        Bounds bounds = ((Wall) event.getTarget()).getBoundsInLocal();
        Bounds screenBounds = localToScreen(bounds);

        /*
        if(isHorizontal){
            moveCursor(event.getScreenX() + getStrokeWidth()/2, event.getScreenY());
        } else {
            moveCursor(event.getScreenX(), event.getScreenY() + getStrokeWidth()/2);
        }
        */

        setStrokeWidth(15);
    }

    /**
     * Déplace la sourie a la position souhaité.
     * @param screenX Position x
     * @param screenY Position y
     */
    private void moveCursor(double screenX, double screenY) {
        Platform.runLater(() -> {
            try {
                Robot robot = new Robot();
                robot.mouseMove((int)screenX, (int)screenY);
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }


    @Override
    public boolean isDrawable() {
        return getSize() > 20 && !isTheSameSourceAndDest();
    }

    private boolean isTheSameSourceAndDest(){
        return false;
        /*
        if(!(getSourceObject() instanceof Wall) || !(getDestinationObject() instanceof Wall)) return true;
        else {
            return !getSourceObject().equals(getDestinationObject());
        }
        */
    }

    @Override
    public void setOnFinalColor(){
        setStroke(Color.rgb(54, 54, 54));
    }

    public Set<Wall> getIntersectWalls() {
        return intersectWalls;
    }

    public void addIntersectWall(Wall intersectWall) {
        this.intersectWalls.add(intersectWall);
    }

    public HomeObject getDestinationObject() {
        return destination;
    }

    public void setDestinationObject(HomeObject destination) {
        this.destination = destination;
    }

    /*
    @Override
    public String toString() {
        return getName();
    }
    */
}