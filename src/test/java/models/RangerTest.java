package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    @Test
    public void Ranger_Instantiates_True(){
        Ranger ranger = new Ranger("George Stephen","0786720383","Yazz77stevie@gmail.com");
        assertEquals(true,ranger instanceof Ranger);
    }
    @Test
    public void Ranger_getName(){
        Ranger ranger = new Ranger("George Stephen","0786720383","Yazz777stevie@gmail.com");
        assertEquals("George Stephen",ranger.getName());
    }
    @Test
    public void Ranger_getPhone(){
        Ranger ranger = new Ranger("George Stephen","0786720383","Yazz777stevie@gmail.com");
        assertEquals("0786720383", ranger.getPhone());
    }
    @Test
    public void Ranger_getEmail(){
        Ranger ranger = new Ranger("George Stephen","0786720383","Yazz777stevie@gmail.com");
        assertEquals("Yazz777stevie@gmail.com",ranger.getEmail());
    }
    @Test
    public void Ranger_Equals(){
        Ranger ranger = new Ranger("George Stephen","0786720383","Yazz777stevie@gmail.com");
        Ranger ranger_2 = new Ranger("George Stephen","0786720383","Yazz777stevie@gmail.com");
        assertEquals(true,ranger.equals(ranger_2));

    }

}