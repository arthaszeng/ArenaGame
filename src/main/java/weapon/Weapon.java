package weapon;

import java.util.Random;

public class Weapon {
    protected String name;
    protected int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
//为了呈现多态，下面5个方法是空的
    public String getWeaponType() {
        return "";
    }

    public String getProcName() {
        return "";
    }

    public int getAtkRounds() {
        return 0;
    }

    public int getProcDamage() {
        return 0;
    }

    public boolean judgePorc(Random random) {
        return false;
    }


    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

}
