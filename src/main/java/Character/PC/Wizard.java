package Character.PC;

import Character.IAttack;
import Character.Characters;
import Inventory.Spell;
import NPC.Familiar;

import java.util.ArrayList;

public class Wizard extends PC implements IAttack {
    private Familiar familiar;
    private ArrayList<Spell> spells;
    private Spell selectedSpell;

    public Wizard (int HP, int defence, String name, Familiar familiar) {
        super(HP, defence, name);
        this.familiar = familiar;
        this.spells = new ArrayList<>();
    }

    public void attack(Characters target){
        int damage = this.castSpell() - target.getDefence();
        if (damage > 1) {
            target.takeDamage(damage);
        } else {
            target.takeDamage(1);
        }
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Spell getSelectedSpell() {
        return selectedSpell;
    }

    public void setSelectedSpell(Spell selectedSpell) {
        if (this.spells.contains(selectedSpell)) {
            this.selectedSpell = selectedSpell;
        }
    }

    public int castSpell(){
        return this.selectedSpell.getDamage();
    }

    public void learnSpell(Spell spell) {
        if (!this.spells.contains(spell)) {
            this.spells.add(spell);
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (this.familiar.isAlive()) {
            this.familiar.takeDamage(damage);
        } else {
            int newHP = this.getHP() - damage;
            this.setHP(newHP);
        }
        if (this.getHP() <= 0) {
            this.setAlive(false);
        }
    }
}
