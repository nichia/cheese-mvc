package org.launchcode.cheesemvc.models.cheese;

public enum CheeseType {
    HARD("Hard"),
    SOFT("Soft"),
    FAKE("Fake");

    private final String name;

    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
