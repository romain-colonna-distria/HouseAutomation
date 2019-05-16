package homeObject;

import homeObject.complex.Field;

public interface HomeObject {
    void create();
    void draw(Field areaDrawingHouse, boolean isFinalShape);
    boolean isDrawable();
    String getName();
}
