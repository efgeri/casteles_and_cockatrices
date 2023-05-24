package Character.PC;

import Character.IAttack;
import Inventory.Armor;
import Inventory.Weapon;
import Character.Characters;

public class Knight extends PC implements IAttack{
    private Weapon weapon;
    private Armor armor;

    public Knight(int HP, int defence, String name, Weapon weapon) {
        super (HP, defence, name);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Characters target){
        int damage = this.getWeapon().getDamage();
        target.takeDamage(damage);
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
        int newDefence = this.getDefence() + this.armor.getDefense();
        this.setDefence(newDefence);
    }
}
