package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class locationTest {
    @Test
    public void Location_instanciatesCorrectly(){
        location testLocation = new location("By the river");
        assertEquals(true,testLocation instanceof location);
    }
 @Test
    public void Location_getName(){
     location testLocation = new location("By the river");
     assertEquals("By the river",testLocation.getLocation());
 }


}