package Character.PC;
import Character.Characters;

import Behaviour.Healable;
import Inventory.MedPack;

import java.util.ArrayList;

public class Healer extends PC{
    private ArrayList<MedPack> medPacks;
    private MedPack selectedMedPack;

    public Healer(int HP, int defence, String name, int maxHP) {
        super(HP, defence, name, maxHP);
        this.medPacks = new ArrayList<>();
    }

    public MedPack getSelectedMedPacks() {
        return selectedMedPack;
    }

    public void setSelectedMedPacks(MedPack selectedMedPack) {
        this.selectedMedPack = selectedMedPack;
    }

    public void craftMedPack(MedPack medPack){
        this.medPacks.add(medPack);
    }

    public void heal(Healable target){
        Characters character = (Characters) target;
        character.setHP(character.getHP() + this.selectedMedPack.getHealValue());
    }
}
