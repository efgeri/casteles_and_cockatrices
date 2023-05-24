package Character.PC;

import Character.PC.Knight;
import Character.Characters;
import Inventory.Armor;
import Inventory.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Armor armor;
    Armor armor1;
    Weapon weapon;
    Weapon weapon1;
    @Before
    public void before(){
        weapon = new Weapon("Axe", 20);
        weapon1 = new Weapon("Dagger", 10);
        armor = new Armor("Plate", 8);
        armor1 = new Armor("Leather", 6);
        knight = new Knight(50, 5, "Johnny the Defender", weapon, 50);
    }

    @Test
    public void canEquipArmor(){
        knight.equipArmor(armor1);
        assertEquals(11, knight.getDefence());
    }

    @Test
    public void canEquipWeapon() {
        assertEquals("Axe", knight.getWeapon().getName());
        knight.equipWeapon(weapon1);
        assertEquals("Dagger", knight.getWeapon().getName());
    }

    @Test
    public void canAttack() {
        knight.equipArmor(armor);
        knight.attack(knight);
        assertEquals(43, knight.getHP());
        knight.equipWeapon(weapon1);
        knight.attack(knight);
        assertEquals(42, knight.getHP());
    }

}
