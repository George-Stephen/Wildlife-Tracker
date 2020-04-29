package models;

import static org.junit.Assert.*;
import org.junit.*;

public class AnimalTest {

    @Test
    public void Animal_instantiates_true(){
        Animal testAnimal = new Animal("Lion");
        assertEquals(true,testAnimal instanceof Animal);
    }
    @Test
    public void Animal_getName(){
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion",testAnimal.getName());
    }
    @Test
    public void Animal_equalObject(){
        Animal testAnimal = new Animal("Lion");
        Animal testAnimal_2 = new Animal("Lion");
        assertEquals(true,testAnimal.equals(testAnimal_2));
    }


}