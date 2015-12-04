package player;

public class Warrior extends SpecialRole {
    public Warrior(String name, int hp, int damage) {
        super( name, hp, damage );
        this.role = "战士";
        this.weaponType = "中";
        this.bestWeaponType = "中";
    }


}
