import weapon.CritWeapon;

import static java.lang.String.format;

public class Arena {
    private OutOfCustom outOfCustom ;

    public Arena(OutOfCustom outOfCustom) {
        this.outOfCustom = outOfCustom;
    }

    public void fighting(Player playerA, Player playerB) {
        Player attacker = playerA;
        Player defender = playerB;
        Player loser = attacker;

        while (attacker.isAlive()){
            outOfCustom.printf(format("%s", attacker.attack(defender)) );
            String msg = defender.beAttacked(attacker);
            if(!msg.isEmpty()){
                outOfCustom.printf(format("%s\n", msg));
            }
            loser = defender;
            defender = attacker;
            attacker = loser;
        }

        outOfCustom.printf(format("%s被击败了\n", loser.getName()));
    }

    public static void main(String args[]) {
        OutOfCustom outOfCustom = new OutOfCustom();
        Arena arena = new Arena( outOfCustom );
        Warrior sharon = new Warrior("Sharon", 30, 2);
        Warrior sli  = new Warrior( "Sli", 30, 2 );

        sharon.equipWeapen(new CritWeapon( "风剑", 1, 1, 2, 0.5));
        sharon.equipArmor( new Armor( "优质秋裤", 1 ) );
        sli.equipWeapen(new CritWeapon( "风剑", 1, 1, 2, 0.5));
        sli.equipArmor( new Armor( "优质秋裤", 1 ) );

        arena.fighting( sli, sharon );
    }
}
