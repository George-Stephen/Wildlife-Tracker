package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Test
    public void Endangered_instanciates_true(){
        Endangered testAnimal = new Endangered("Sabertooth","okay",12,1,0);
        assertEquals(true,testAnimal instanceof Endangered);
    }
    @Test
    public void Endangered_name(){
        Endangered testAnimal = new Endangered("Sabertooth","okay",12,1,0);
        assertEquals("Sabertooth",testAnimal.getName());
    }
    @Test
    public void Endangered_Age(){
        Endangered testAnimal = new Endangered("Sabertooth","okay",12,1,0);
        assertEquals(12,testAnimal.getAge());
    }
    @Test
    public void Endangered_equals(){
        Endangered testAnimal = new Endangered("Sabertooth","okay",12,1,0);
        Endangered testAnimal2 = new Endangered("Sabertooth","okay",12,1,0);
        assertEquals(true,testAnimal.equals(testAnimal2));
    }

}