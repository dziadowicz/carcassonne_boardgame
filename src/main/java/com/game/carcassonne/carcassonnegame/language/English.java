package com.game.carcassonne.carcassonnegame.language;

import java.util.ArrayList;
import java.util.List;

public class English {

    private static final String name = "english";

    public static String getName() {
        return name;
    }

    public static final List<String> getEnglish() {

        List<String> english = new ArrayList<>();

        english.add(0, "Carcassonne game");
        english.add(1, "Put square");

        return english;
    }
}
