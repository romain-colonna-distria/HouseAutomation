package homeObject.simple;


import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

public class Window extends HomeObjectSimple {
    private static int windowId = 0;


    public Window() {
        super("Window" + ++windowId);
        setStrokeWidth(2);
    }

    @Override
    public void create() {
        getElements().clear();
        if(getWidth() > getHeight()) {
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX() + 10, getY() + getWidth()/2 - 5));
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX(), getY() + getWidth() - (getWidth() < 5 ? getWidth() : 5)));
            getElements().add(new MoveTo(getX(), getY() + getWidth() - (getWidth() < 5 ? getWidth() : 5)));
            getElements().add(new LineTo(getX() + 10, getY() + getWidth()/2 + 5));
        } else {
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX() + getHeight()/2 - 5, getY() + 10));
            getElements().add(new MoveTo(getX(), getY()));
            getElements().add(new LineTo(getX() + getHeight() - (getHeight() < 5 ? getHeight() : 5), getY()));
            getElements().add(new MoveTo(getX() + getHeight() - (getHeight() < 5 ? getHeight() : 5), getY()));
            getElements().add(new LineTo(getX() + getHeight()/2 + 5, getY() + 10));
        }
    }

    @Override
    public boolean isDrawable() {
        return getSourceObject() instanceof Wall;
    }

    @Override
    public void setOnFinalColor() {
        setStroke(Color.BLACK);
    }
}
