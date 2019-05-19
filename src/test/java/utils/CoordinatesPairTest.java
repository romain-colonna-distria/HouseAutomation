package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinatesPairTest {
    private CoordinatesPair point = new CoordinatesPair(1,2);
    private CoordinatesPair point1 = new CoordinatesPair(0,0);
    private CoordinatesPair point2 = new CoordinatesPair(-1,-2);
    private CoordinatesPair point3 = new CoordinatesPair(1,0);

    @Test
    void testConstructor(){
        assertEquals(1, point.getX1(),"Compare la valeur de x1");
        assertEquals(2, point.getY1(),"Compare la valeur de y2");
        assertEquals(0, point1.getX1(),"Compare la valeur de x1");
        assertEquals(0, point1.getY1(),"Compare la valeur de y1");
        assertEquals(-1, point2.getX1(),"Compare la valeur de x1");
        assertEquals(-2, point2.getY1(),"Compare la valeur de y1");
    }

    @Test
    void testGetDistance(){
        assertEquals(1,point3.getDistance());
        assertEquals(0,point1.getDistance());
    }

    @Test
    void testGetDistanceBetweenX(){
        assertEquals(1,point.getDistanceBetweenX());
        assertEquals(1, point2.getDistanceBetweenX());
        assertEquals(0, point1.getDistanceBetweenX());
    }

    @Test
    void testGetDistanceBetweenY(){
        assertEquals(2, point.getDistanceBetweenY());
        assertEquals(0,point1.getDistanceBetweenY());
        assertEquals(2,point2.getDistanceBetweenY());
    }

    @Test
    void testGetX1(){
        assertEquals(1,point.getX1());
    }

    @Test
    void testGetY1(){
        assertEquals(2, point.getY1());
    }

    @Test
    void testGetX2(){
        assertEquals(0,point.getX2());
    }

    @Test
    void testGetY2(){
        assertEquals(0,point.getY2());
    }


}
