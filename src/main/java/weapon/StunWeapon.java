package weapon;

public class StunWeapon extends ProcWeapon {
    public StunWeapon(String name, int damage, int charactorDamge, int atkRounds, double rate) {
        super( name, damage, charactorDamge, atkRounds, rate );
        procName = "被眩晕";
    }
}
