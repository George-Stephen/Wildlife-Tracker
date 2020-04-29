package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void Sighting_available(){
        Sighting sighting = new Sighting(1,"Found a new cub",2,01);
        assertEquals(true, sighting instanceof Sighting);
    }
    @Test
    public void Sighting_getReport(){
        Sighting sighting = new Sighting(1,"Found a new cub",2,01);
        assertEquals("Found a new cub",sighting.getReport());
    }
    @Test
    public void Sighting_equal() {
        Sighting sighting = new Sighting(1, "Found a new cub", 2, 01);
        Sighting sighting_2 = new Sighting(1, "Found a new cub", 2, 01);
        assertEquals(true,sighting.equals(sighting_2));
    }
}