package NPC;
import Character.Characters;
import Behaviour.Healable;

public class Familiar extends Characters implements Healable {

    public Familiar(int HP, int defence, String name, int maxHP) {
        super(HP, defence, name, maxHP);
    }

}
