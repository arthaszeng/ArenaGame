package player;

public class Knight extends SpecialRole {
    public Knight(String name, int hp, int damage) {
        super( name, hp, damage );
        this.role = "骑士";
        this.weaponType = "中长";
        this.bestWeaponType = "长";
    }
}
