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
    @Test
    public void newHero_getAge_Int(){
        assertEquals(25, Hero.getAge());
    }
    @Test
    public void newHero_getPower_String(){
        assertEquals("Empathy", Hero.getPower());
    }
    @Test
    public void newHero_getWeakness_String()
    {
        assertEquals("kind", Hero.getWeakness());
    }

    @Test
    public void newHero_getAllInstances_true(){
        Hero Hero = new Hero("Aces", 25, "Empathy", "kind");
        Hero anotherHero = new Hero("Morio", 21, "Just", "alcoholic");
        assertEquals(true, Hero.getAllInstances().contains(Hero));
        assertEquals(true, Hero.getAllInstances(). contains(anotherHero));
    }
    @Test
    public void newHero_getId_Int(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        Hero another1 = Hero.setUpNewHero();
        assertEquals(3, another1.getId());
    }
    @Test
    public void newHero_findById_id(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero another = Hero.setUpNewHero();
        assertEquals(2, Hero.findById(another.getId()).getId());
    }


}