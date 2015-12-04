import weapon.Weapon;

import java.util.Random;

public class Warrior extends Player{
    private Armor armor;

    public Warrior(String name, int hp, int damage) {
        super( name, hp, damage);
        this.role = "战士";
        weapon = new Weapon( "徒手", 0);
        armor = new Armor( "秋裤", 0 );
    }

    public void equipWeapen(Weapon weapon) {
        this.weapon = weapon;
        this.damage += weapon.getDamage();
    }

    public void unequipWeapen() {
        damage -= weapon.getDamage();
        this.weapon = new Weapon( "徒手", 0 );
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public String attack(Player theDefender) {
        if(debuff.isTriggerDebuff()) {
            boolean isStun = debuff.settleDebuf( this );
            if (isStun) {
                return null;
            }
        }
        return String.format("%s%s用%s攻击了%s%s，", getRole(), getName(), weapon.getName(), theDefender.getRole(), theDefender.getName());
    }

    public String beAttacked(Player theAttacker) {
        Weapon weaponBuf = theAttacker.weapon;
        Random random = new Random(  );
        int atkDamage = 0;

        if (!theAttacker.isStun) {
            atkDamage = theAttacker.getDamage() - armor.getDefense();
            atkDamage = atkDamage > 0 ? atkDamage : 0;

            if (weaponBuf != null && weaponBuf.judgePorc( random )) {
                this.debuff = new Debuff( weaponBuf.getProcName(), weaponBuf.getAtkRounds() + this.debuff.getRestRounds(), weaponBuf.getProcDamage() );
                if (weaponBuf.getProcName().equals( "被暴击" )) {
                    atkDamage *= 3;
                }
                hp -= atkDamage;
                return String.format( "%s受到了%d点伤害，%s%s了，%s剩余生命：%d", getName(), atkDamage, getName(), weaponBuf.getProcName(), getName(), getHp() );

            }else {
                hp -= atkDamage;
                return String.format( "%s受到了%d点伤害，%s剩余生命：%d", getName(), atkDamage, getName(), getHp() );
            }

        }else{
            theAttacker.isStun = false;
            return "";
        }
     }

}
