package models;

import java.util.ArrayList;

public class Squad {
    private int SquadId;
    private String squadName;
    private int squadSize;
    private String cause;

    public Squad(String name, int size, String cause) {
        squadName = name;
        squadSize = size;
        this.cause = cause;
    }

    public static Squad setUpNewSquad() {
        return new Squad("Warriors", 5, "Fight corruption");
    }
}
