package weapon;

public class ToxicityWeapon extends ProcWeapon {
    public ToxicityWeapon(String name, int damage, String weaponType, int charactorDamge, int atkRounds, double rate) {
        super( name, damage, charactorDamge, atkRounds, rate );
        procName = "中毒";
        this.weaponType = weaponType;
    }
}
