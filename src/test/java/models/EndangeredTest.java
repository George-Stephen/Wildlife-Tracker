package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void Endangered_instanciates_true(){
        Endangered testAnimal = new Endangered("Sabertooth","okay","young","steve");
        assertEquals(true,testAnimal instanceof Endangered);
    }
    @Test
    public void Endangered_name(){
        Endangered testAnimal = new Endangered("Sabertooth","okay","young","steve");
        assertEquals("Sabertooth",testAnimal.getName());
    }
    @Test
    public void Endangered_Age(){
        Endangered testAnimal = new Endangered("Sabertooth","okay","young","steve");
        assertEquals("young",testAnimal.getAge());
    }
    @Test
    public void Endangered_equals(){
        Endangered testAnimal = new Endangered("Sabertooth","okay","young","steve");
        Endangered testAnimal2 = new Endangered("Sabertooth","okay","young","steve");
        assertEquals(false,testAnimal.equals(testAnimal2));
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_false() {
        Endangered firstEndangeredAnimal = new Endangered("Fox", "Healthy", "Young","Barry");
        firstEndangeredAnimal.save();
        Endangered secondEndangeredAnimal = new Endangered("wolf", "Okay", "Adult","Joseph");
        secondEndangeredAnimal.save();
        assertEquals(false, Endangered.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(false, Endangered.all().get(1).equals(secondEndangeredAnimal));
    }

}