package models;

import java.util.ArrayList;

public class Hero {
      private static String name;
       private static int age;
       private static String power;
       private static String weakness;
       private static ArrayList<Hero> instances = new ArrayList();
       private int id;

    public Hero (String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();


    }

    public static Hero setUpNewHero() {
        return  new Hero("Aces", 25, "Empathy", "kind");
    }
    public static Hero findById(int id) {
        return instances.get(id-1);
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
    public static ArrayList<Hero>getAllInstances(){
        return instances;
    }

    public static int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
