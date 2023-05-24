package Inventory;

public abstract class Inventory {
    String name;

    public Inventory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
