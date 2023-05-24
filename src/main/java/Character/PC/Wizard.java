package Character.PC;

import Behaviour.IAttack;
import Character.Characters;
import Inventory.Spell;
import NPC.Familiar;

import java.util.ArrayList;

public class Wizard extends PC implements IAttack {
    private Familiar familiar;
    private ArrayList<Spell> spells;
    private Spell selectedSpell;

    public Wizard (int HP, int defence, String name, Familiar familiar, int maxHP) {
        super(HP, defence, name, maxHP);
        this.familiar = familiar;
        this.spells = new ArrayList<>();
    }

    public void attack(Characters target){
        int damage = this.castSpell();
        target.takeDamage(damage);

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
