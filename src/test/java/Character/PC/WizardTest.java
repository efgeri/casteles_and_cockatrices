package Character.PC;

import Inventory.Spell;
import Inventory.Weapon;
import NPC.Familiar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard1;
    Familiar turtle;
    Spell fireball;
    Spell magicMissile;
    Knight knight;
    Weapon weapon;

    @Before
    public void before() {
        turtle = new Familiar(10, 15, "Winslow", 10);
        fireball = new Spell("Fireball", 15);
        magicMissile = new Spell("Magic Missile", 10);
        wizard1 = new Wizard(20, 0, "Tim", turtle, 20);
        wizard1.learnSpell(magicMissile);
        wizard1.setSelectedSpell(magicMissile);
        weapon = new Weapon("Axe", 20);
        knight = new Knight(50, 5, "Johnny the Defender", weapon, 50);

    }

    @Test
    public void canLearnSpells() {
        wizard1.learnSpell(fireball);
        wizard1.learnSpell(fireball);
        assertEquals(2, wizard1.getSpells().size());
    }

    @Test
    public void canAttack() {
        wizard1.attack(knight);
        assertEquals(45, knight.getHP());
    }

    @Test
    public void cannotSetSpell() {
        wizard1.setSelectedSpell(fireball);
        assertEquals("Magic Missile", wizard1.getSelectedSpell().getName());
    }

    @Test
    public void canRedirectDamageToFamiliar() {
        wizard1.attack(wizard1);
        assertEquals(20, wizard1.getHP());
        assertEquals(9, turtle.getHP());
    }

    @Test
    public void canAttackWizardAfterKillingFamiliar() {
        knight.attack(wizard1);
        knight.attack(wizard1);
        knight.attack(wizard1);
        assertEquals(false, turtle.isAlive());
        assertEquals(0, wizard1.getHP());
        assertEquals(false, wizard1.isAlive());

    }
}
