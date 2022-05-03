package models;

import java.util.ArrayList;

public class Squad {
    private int SquadId;
    private static String squadName;
    private static int squadSize;
    private static String cause;

    public Squad(String name, int size, String cause) {
        this.squadName = name;
        this.squadSize = size;
        this.cause = cause;
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
}
