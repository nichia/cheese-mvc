package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    // add
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    // remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // update
    public static void update(Cheese theCheese) {
        Cheese cheeseToEdit = getById(theCheese.getCheeseId());
        cheeseToEdit.setName(theCheese.getName());
        cheeseToEdit.setDescription(theCheese.getDescription());
        cheeseToEdit.setType(theCheese.getType());
        cheeseToEdit.setRating(theCheese.getRating());
    }

    // getById
    public static Cheese getById(int id) {
        Cheese theCheese = null;
        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id)  {
                theCheese = candidateCheese;
                break;
            }
        }
        return theCheese;
    }
}
