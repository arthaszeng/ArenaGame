package player;

public class Assassin extends SpecialRole {
    public Assassin(String name, int hp, int damage) {
        super( name, hp, damage );
        this.role = "刺客";
        this.weaponType = "短中";
        this.bestWeaponType = "短";
    }
}
