package Character.PC;

import Inventory.MedPack;
import Inventory.Spell;
import Inventory.Weapon;
import NPC.Familiar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealerTest {

    Wizard wizard1;
    Familiar turtle;
    Spell fireball;
    Spell magicMissile;
    Knight knight;
    Weapon weapon;
    Healer healer;
    MedPack medPack;

    @Before
    public void before() {
        turtle = new Familiar(1, 15, "Winslow", 10);
        fireball = new Spell("Fireball", 15);
        magicMissile = new Spell("Magic Missile", 10);
        wizard1 = new Wizard(20, 0, "Tim", turtle, 20);
        wizard1.learnSpell(magicMissile);
        wizard1.setSelectedSpell(magicMissile);
        weapon = new Weapon("Axe", 10);
        knight = new Knight(50, 5, "Johnny the Defender", weapon, 50);
        healer = new Healer(40, 5, "Medic!", 40);
        medPack = new MedPack("Potion", 10);
        healer.craftMedPack(medPack);
        healer.setSelectedMedPacks(medPack);
    }

    @Test
    public void canHeal(){
        knight.attack(wizard1); // first attack only kills turtle
        knight.attack(wizard1);
        assertEquals(10, wizard1.getHP());
        healer.heal(wizard1);
        assertEquals(20, wizard1.getHP());
    }
}
