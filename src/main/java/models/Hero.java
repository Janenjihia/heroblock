package models;

import java.util.ArrayList;

public class Hero {
      private static String name;
       private static int age;
       private static String power;
       private static String weakness;

    public Hero (String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
    }

    public static Hero setUpNewHero() {
        return  new Hero("Aces", 25, "Empathy", "kind");
    }

    public static String getName() {
        return name;
    }

    public static String getWeakness() {
        return weakness;
    }

    public static String getPower() {
        return power;
    }

    public static int getAge() {
        return age;
    }

}
