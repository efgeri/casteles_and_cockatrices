package NPC.Foes;
import Character.Characters;
import Behaviour.IAttack;
public class Foe extends Characters implements IAttack{
    int attack;
    public Foe(int HP, int defence, String name, int attack, int maxHP) {
        super(HP, defence, name, maxHP);
        this.attack = attack;
    }

    public void attack(Characters target){

    }
}
