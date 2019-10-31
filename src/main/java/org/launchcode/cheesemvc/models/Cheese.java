package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {
    private String name;
    private String description;
    static HashMap<String, String> cheeses = new HashMap<>();

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
        cheeses.put(this.name, this.description);
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public static HashMap<String, String> getCheeses() {
        return cheeses;
    }

    public static void removeCheese(String aCheese) {
        cheeses.remove(aCheese);
    }
}
