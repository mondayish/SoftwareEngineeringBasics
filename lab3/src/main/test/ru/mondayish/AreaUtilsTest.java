package ru.mondayish;

import org.junit.Test;
import ru.mondayish.utils.AreaUtils;

import static org.junit.Assert.*;

public class AreaUtilsTest {

    private final static double R = 10;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnNegativeRadius() {
        AreaUtils.getResultOfShot(12, 42, -1);
    }

    @Test
    public void isInRightTopTest(){
        for(double x = 0.0; x <= R; x+=1.0){
            for(double y = 0.0; y <= R/2; y+=1.0){
                assertTrue(AreaUtils.getResultOfShot(x, y, R));
            }
        }
    }

    @Test
    public void isInLeftTopTest(){
        for(double x = -1.0; x >= -R; x-=1.0){
            for(double y = 1.0; y <= R; y+=1.0){
                assertFalse(AreaUtils.getResultOfShot(x, y, R));
            }
        }
    }

    @Test
    public void isInRightBottomTest(){
        for(double x = 0.0; x <= R/2; x+=1.0){
            for(double y = 0.0; y >= -R/2; y-=1.0){
                assertEquals(AreaUtils.getResultOfShot(x, y, R), R * R / 4 >= x * x + y * y);
            }
        }
    }

    @Test
    public void isInLeftBottomTest(){
        for(double x = 0.0; x >= -R; x-=1.0){
            for(double y = 0.0; y >= -R/2; y-=1.0){
                assertEquals(AreaUtils.getResultOfShot(x, y, R), y >= -x / 2 - R / 2);
            }
        }
    }

    @Test
    public void shotOutsideTest(){
        for(int i = 0; i < 10; i++){
            double c = (Math.random() + 1.01) * R;
            assertFalse(AreaUtils.getResultOfShot(c, c, R));
            assertFalse(AreaUtils.getResultOfShot(-c, c, R));
            assertFalse(AreaUtils.getResultOfShot(c, -c, R));
            assertFalse(AreaUtils.getResultOfShot(-c, -c, R));
        }
    }
}
