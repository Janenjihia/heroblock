package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
Hero hero =new Hero("Aces", 25, "Empathy", "kind");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void newHero_instantiatesCorrectly_true(){
        Hero newHero = Hero.setUpNewHero();
        assertEquals(true, newHero instanceof Hero);
    }
    @Test
    public void newHero_getName_String(){
        assertEquals("Aces", Hero.getName());
    }
}