package com.game.carcassonne.carcassonnegame.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Language {

    private String language = Polish.getName();
    private final static List<String> availableLanguages = new ArrayList<>(Arrays.asList(English.getName(), Polish.getName()));

    public static List<String> getAvailableLanguages() {
        return availableLanguages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) throws WrongLanguageException {
        if (availableLanguages.contains(language)) {
            this.language = language;
        } else {
            throw new WrongLanguageException();
        }
    }

    public String getString (int line) {

        if (language.equals(English.getName())) {
            return English.getEnglish().get(line);
        } else if (language.equals(Polish.getName())) {
            return Polish.getPolish().get(line);
        } else return "Something went wrong";
    }

}
