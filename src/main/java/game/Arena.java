package game;

import player.Assassin;
import player.AveragePerson;
import player.Knight;
import player.SpecialRole;
import weapon.Armor;
import weapon.CritWeapon;
import weapon.StunWeapon;

import static java.lang.String.format;

public class Arena {
    private OutOfCustom outOfCustom ;

    public Arena(OutOfCustom outOfCustom) {
        this.outOfCustom = outOfCustom;
    }

    public void fighting(AveragePerson averagePersonA, AveragePerson averagePersonB) {
        AveragePerson attacker = averagePersonA;
        AveragePerson defender = averagePersonB;
        AveragePerson loser = attacker;

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
        SpecialRole sharon = new Assassin("Sharon", 20, 2);
        SpecialRole sli  = new Knight( "Sli", 20, 2 );

        sharon.equipWeapen(new CritWeapon( "风剑", 1, "长", 1, 2, 0.5));
        sharon.equipArmor( new Armor( "优质秋裤", 1 ) );
        sli.equipWeapen(new StunWeapon( "兄弟会之剑", 1, "长", 1, 2, 0.2));
        sli.equipArmor( new Armor( "优质秋裤", 1 ) );

        arena.fighting( sli, sharon );
    }
}
