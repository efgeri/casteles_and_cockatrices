package Character;

public abstract class Characters {
    String name;

    private int HP;
    private int defence;
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Characters(int HP, int defence, String name) {
        this.name = name;
        this.HP = HP;
        this.defence = defence;
        this.alive = true;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void takeDamage(int damage) {
        int modifiedDamage = damage - this.defence;
        if (modifiedDamage < 0) {
            this.HP--;
        } else {
            this.HP -= modifiedDamage;
        }
        if (this.HP <= 0) {
            this.setAlive(false);
        }
    }
}
