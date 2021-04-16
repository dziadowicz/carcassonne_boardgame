package com.game.carcassonne.carcassonnegame.language;

import java.util.ArrayList;
import java.util.List;

public class Polish {

    private static final String name = "polski";

    public static String getName() {
        return name;
    }

    public static List<String> getPolish() {

        List<String> polish = new ArrayList<>();

        polish.add(0, "Carcassonne gra");
        polish.add(1, "Umieść pole");

        return polish;
    }




}
