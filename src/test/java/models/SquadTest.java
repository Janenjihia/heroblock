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


    @Test
    public void getName() {
        assertEquals("Warriors", Squad.getName());
    }

    @Test
    public void getSize() {
        assertEquals(5, Squad.getSize());
    }

    @Test
    public void getCause() {
        assertEquals("Fight corruption", Squad.getCause());
    }
    @Test
    public void newSquad_getSquadMembers_Array() {
        Squad Squad = new Squad("warlord", 15, "Fight corruption");
        Hero Hero = new Hero("warriors", 5, "Fight corruption", "kind");
        Hero newHero1 = new Hero("warriors", 5, "Fight corruption", "kind");
        Squad.setSquadMembers(Hero);
        assertEquals("warriors", Squad.getSquadMembers().get(0).getName());
    }
    @Test
    public void newSquad_allTestSquadMembers_Array(){
        Hero Hero = new Hero("warlord", 15, "Fight corruption", "kind");
        Squad Squad = new Squad("warriors", 5, "Fight corruption");
        Squad.clearAllSquadMembers();
        Squad.getSquadMembers().add(Hero);
        Squad.getSquadMembers().add(Hero);
        assertEquals("warriors", Squad.getSquadMembers().get(0).getName());
    }
    @Test
    public void addMember_addMemberToSquad_Hero(){
        Hero Hero = new Hero("warlord", 15, "Fight corruption", "kind");
        Squad testSquad =new Squad("warriors", 5, "Fight corruption");
        Squad newSquad = Squad.findBySquadId(1);
        newSquad.clearAllSquadMembers();
        newSquad.getSquadMembers().add(Hero);
        newSquad.getSquadMembers().add(Hero);
        assertEquals(2, newSquad.getSquadMembers().size());
    }
    @Test
    public void setNewMember_hero(){
        Hero.clearAllHeroes();
        Hero Hero = new Hero("warlord", 15, "Fight corruption", "kind");
        Squad testSquad =new Squad("warriors", 5, "Fight corruption");
        testSquad.setSquadMembers(Hero);
        assertEquals(1, testSquad.getSquadMembers().get(0).getId());
    }
    @Test
    public void newSquad_getId_Int(){
        Hero.clearAllHeroes();
        Hero newHero = Hero.setUpNewHero();
        Hero anotherHero = Hero.setUpNewHero();
        Hero another1 = Hero.setUpNewHero();
        assertEquals(3, another1.getId());
    }
}