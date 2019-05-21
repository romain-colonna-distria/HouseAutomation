package controller;

import homeObject.*;
import homeObject.HomeObject;
import homeObject.complex.Field;
import homeObject.complex.HomeObjectComplex;
import homeObject.complex.Room;
import homeObject.entity.HomeObjectEntity;
import homeObject.simple.HomeObjectSimple;
import homeObject.simple.Wall;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import utils.CoordinatesPair;

import java.io.IOException;
import java.util.ArrayList;

public class ConstructHomeController {
    /**
     * Liste de tous les objets (formes) présent dans la contruction.
     */
    private ArrayList<HomeObject> homeObjects = new ArrayList<>();
    private ArrayList<HomeObject> delObjects = new ArrayList<>();
    /**
     * Paire de coordonnées utile pour placer les formes.
     */
    private CoordinatesPair coordinatesPair;

    private String shapeName;
    /**
     * Forme a placer sur le shéma.
     */
    private HomeObject shape;

    private Label coordinates = new Label();

    @FXML
    private Field field;

    @FXML
    private VBox objectsInformationsVBox;



    /**
     * Event handler détectant le clique de la sourie (enclanchement du clique) sur la zone de construction
     * (en mode construction). Initialise le premier point de la paire de coordonnées.
     */
    private EventHandler<MouseEvent> moussePressedOnConstructViewforConstructEvent =  new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            try {
                shape = HomeObjectFactory.getHomeObject(shapeName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            coordinatesPair = new CoordinatesPair(event.getX(), event.getY());

            if(shape instanceof HomeObjectSimple){
                ((HomeObjectSimple) shape).setStartPoints(event.getX(), event.getY());
                ((HomeObjectSimple) shape).setSourceObject(event.getTarget() instanceof HomeObject ? (HomeObject) event.getTarget() : null);
            }
        }
    };

    private EventHandler<MouseEvent> dragDetectedOnConstructViewForConstructEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            field.startFullDrag();
        }
    };

    private EventHandler<MouseEvent> mousseDragOnConstructViewForConstructEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            coordinatesPair.setX2(event.getX());
            coordinatesPair.setY2(event.getY());


            if(shape instanceof HomeObjectSimple){
                ((HomeObjectSimple) shape).setDimensions(coordinatesPair.getDistanceBetweenY(), coordinatesPair.getDistanceBetweenX());
            }


            shape.draw(field, false);
        }
    };

    /**
     * Event handle détectant la fin du clique de la sourie (relachement du clique) (en mode construction).
     * Crée la forme final.
     */
    private EventHandler<MouseEvent> mousseDragReleasedOnConstructViewforConstructEvent =  new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(shape instanceof Wall){
                ((Wall) shape).setDestinationObject((HomeObject)event.getTarget());
            }

            if(shape.isDrawable()) {
                shape.draw(field, true);
                homeObjects.add(shape);
            }
            else {
                field.getChildren().remove(shape);
                homeObjects.remove(shape);
            }
        }
    };




    private EventHandler<MouseEvent> moussePressedOnConstructViewforConstructEntityEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(!(event.getTarget() instanceof HomeObjectComplex)) return;
            ((HomeObjectEntity) shape).setRoot((HomeObjectComplex) event.getTarget());
            ((HomeObjectEntity) shape).setCoordinates(event.getX(), event.getY());
            shape.draw(field, true);
            homeObjects.add(shape);

            if(shape instanceof HomeObjectEntity) {
                HomeObjectEntityAdapter adapter = new HomeObjectEntityAdapter((HomeObjectEntity) shape);

                for(int i = 0; i < objectsInformationsVBox.getChildren().size(); ++i){ //supprime si double
                    String name = ((Label)((AnchorPane)objectsInformationsVBox.getChildren().get(i)).getChildren().get(1)).getText();
                    if(name.equals(shape.getName())){
                        objectsInformationsVBox.getChildren().remove(i);
                    }
                }

                objectsInformationsVBox.getChildren().add(adapter.getPane());
            }
        }
    };




    private EventHandler<MouseEvent> moussePressedOnConstructViewforConstructRoomEvent =  new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(!(event.getTarget() instanceof Wall)) return;
            field.getChildren().remove(shape);
            ((Room) shape).addWall((Wall)event.getTarget());
            shape.draw(field, true);
            homeObjects.add(shape);

            /* remet les murs au premier plan */
            for(Wall wall : ((Room) shape).getWalls()){
                field.getChildren().remove(wall);
                field.getChildren().add(wall);
            }
        }
    };





    private EventHandler<MouseEvent> mousseFlyOverConstructView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            field.getChildren().remove(coordinates);
            field.getChildren().add(coordinates);
            coordinates.setLayoutX(event.getX() + 10);
            coordinates.setLayoutY(event.getY() + 10);
            coordinates.setText("x:" + event.getX() + " y:" + event.getY());
        }
    };

    private EventHandler<MouseEvent> mousseExitedConstructView = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            field.getChildren().remove(coordinates);
        }
    };








    public void init(){
        field.setOnMouseMoved(mousseFlyOverConstructView);
        field.setOnMouseDragged(mousseFlyOverConstructView);
        field.setOnMouseExited(mousseExitedConstructView);
        field.setOnMouseDragExited(mousseExitedConstructView);
    }

    @FXML
    public void buttonObjectSimpleClick(Event event){
        stopConstructEventsHandler();
        field.removeEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructRoomEvent);
        shapeName = ((Button)event.getSource()).getId();
        startConstructEventsHandler();
    }

    @FXML
    public void buttonObjectEntityClick(Event event) throws IOException {
        stopConstructEventsHandler();
        field.removeEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructEntityEvent);
        shape = HomeObjectFactory.getHomeObject(((Button)event.getSource()).getId());
        field.addEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructEntityEvent);
    }

    @FXML
    public void buttonRoomClick(Event event) throws IOException {
        stopConstructEventsHandler();
        field.removeEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructRoomEvent);
        shape = HomeObjectFactory.getHomeObject(((Button)event.getSource()).getId());
        field.addEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructRoomEvent);
    }


    @FXML
    public void undo(){
        if(homeObjects.size() < 1) return;
        HomeObject object = homeObjects.get(homeObjects.size() - 1);
        homeObjects.remove(object);
        field.getChildren().remove(object);
        delObjects.add(object);

        for(int i = 0; i < objectsInformationsVBox.getChildren().size(); ++i){ //supprime l'objet du menu
            if(((Label)((AnchorPane)objectsInformationsVBox.getChildren().get(i)).getChildren().get(0)).getText().equals(shape.getName())){
                objectsInformationsVBox.getChildren().remove(i);
            }
        }
    }

    @FXML
    public void redo(){
        if(delObjects.size() < 1) return;
        HomeObject object = delObjects.get(delObjects.size() - 1);
        delObjects.remove(object);
        homeObjects.add(object);
        field.getChildren().add((Node) object);
    }

    @FXML
    public void changeFocus(Event event){
        stopConstructEventsHandler();
    }

    /**
     * Démarrage des events handler utiles pour la contruction (ajout de formes sur la zone
     * de construction).
     */
    private void startConstructEventsHandler(){
        field.addEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructEvent);
        field.addEventFilter(MouseEvent.DRAG_DETECTED, dragDetectedOnConstructViewForConstructEvent);
        field.addEventFilter(MouseEvent.MOUSE_DRAGGED, mousseDragOnConstructViewForConstructEvent);
        field.setOnMouseDragReleased(mousseDragReleasedOnConstructViewforConstructEvent);
    }

    /**
     * Arrêt des events handler utiles pour la contruction (ajout de formes sur la zone
     * de construction).
     */
    private void stopConstructEventsHandler(){
        field.removeEventFilter(MouseEvent.MOUSE_PRESSED, moussePressedOnConstructViewforConstructEvent);
        field.removeEventFilter(MouseEvent.DRAG_DETECTED, dragDetectedOnConstructViewForConstructEvent);
        field.removeEventFilter(MouseEvent.MOUSE_DRAGGED, mousseDragOnConstructViewForConstructEvent);
        field.removeEventFilter(MouseEvent.MOUSE_RELEASED, mousseDragReleasedOnConstructViewforConstructEvent);
    }
}