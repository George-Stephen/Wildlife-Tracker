package models;

import org.junit.*;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sighting_available(){
        Sighting testSighting = setupNewSighting();
        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Sighting_equal() {
        Sighting testSighting = setupNewSighting();
        Sighting anotherSighting = setupNewSighting();
        assertEquals(true,testSighting.equals(anotherSighting));
    }


    public Sighting setupNewSighting(){
        return new Sighting("Zone A", "Henry");
    }
    public Sighting setupOtherSighting(){
        return new Sighting("Zone B", "Alex");
    }
}