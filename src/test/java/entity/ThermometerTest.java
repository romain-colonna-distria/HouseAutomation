package entity;

import homeObject.entity.Thermometer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThermometerTest {
        Thermometer thermometer = new Thermometer();
        Thermometer thermometer1 = new Thermometer();

        @Test
        void testConstructor(){
            assertEquals(4, thermometer.getThermometerId());
        }

       /* @Test
        void testCreate(){

        }*/

        @Test
        void testIsDrawable(){
            assertTrue(thermometer.isDrawable());
        }
}
