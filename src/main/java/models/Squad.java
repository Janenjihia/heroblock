package models;

import java.util.ArrayList;

public class Squad {
    private final int squadId;
    private int SquadId;
    private static String squadName;
    private static int squadSize;
    private static String cause;
    private static ArrayList<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, int size, String cause) {
        this.squadName = name;
        this.squadSize = size;
        this.cause = cause;
        this.squadMembers = new ArrayList<>();
        instances.add(this);
        this.squadId = instances.size();
    }

    public static Squad setUpNewSquad() {
        return new Squad("Warriors", 5, "Fight corruption");
    }

    public static String getName() {
        return squadName;
    }

    public static int getSize() {
        return squadSize;
    }

    public static String getCause() {
        return cause;
    }
    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public static Squad findBySquadId(int id) {
        return instances.get(id-1);
    }

    public static Squad setUpNewSquad1() {
        return new Squad("Avengers", 5, "Avenge injustices");
    }

    public ArrayList<Hero> getSquadMembers() {
        return squadMembers;
    }

    public void setSquadMembers(Hero hero) {
        squadMembers.add(hero);
    }

}
