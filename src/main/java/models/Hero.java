package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    public Hero (String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
    }

    public static Hero setUpNewHero() {
        return  new Hero("Aces", 25, "Empathy", "kind");
    }

    public String getName() {
        return this.name;
    }

}
