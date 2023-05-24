package Inventory;

public class MedPack extends Inventory{
    private int healValue;

    public MedPack(String name, int healValue) {
        super(name);
        this.healValue = healValue;
    }

    public int getHealValue() {
        return healValue;
    }
}
