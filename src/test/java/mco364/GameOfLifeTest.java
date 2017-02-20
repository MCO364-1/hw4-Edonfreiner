package mco364;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameOfLifeTest {

    @Test
    public void isAliveNextGenerationTest() {
        
        assertTrue(GameOfLife.isAliveNextGeneration(1, 2, 3));
                
    }

    @Test

    public void neighborCountTest() {
        assertEquals(0,GameOfLife.neighborCount(1,2));

    }

}
