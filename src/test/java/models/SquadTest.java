package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
Squad squad=new Squad("Warriors", 5, "Fight corruption");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void newSquad_instantiatesCorrectly_true(){
        Squad newSquad = Squad.setUpNewSquad();
        assertTrue(newSquad instanceof Squad);
    }
    @Test
    public void newSquad_getName_String(){
        assertEquals("Warriors", Squad.getName());
    }
    @Test
    public void newSquad_getSize_Int(){
        assertEquals(5, Squad.getSize());
    }
    @Test
    public void newSquad_getCause_String(){
        assertEquals("Fight corruption", Squad.getCause());
    }
}