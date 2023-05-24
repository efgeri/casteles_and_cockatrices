package Character.PC;

import Behaviour.Healable;
import Character.Characters;
import Inventory.Treasure;

import java.util.ArrayList;

public abstract class PC extends Characters implements Healable {
    private ArrayList<Treasure> treasures;

    public PC(int HP, int defence, String name, int maxHP) {
        super(HP, defence, name, maxHP);
        this.treasures = new ArrayList<>();
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }
}
