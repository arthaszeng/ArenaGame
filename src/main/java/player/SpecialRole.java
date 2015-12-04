package player;

import weapon.Armor;
import weapon.Weapon;

import java.util.Random;

public class SpecialRole extends AveragePerson {
    protected Armor armor;
    //特殊角色共同属性，可以装备的武器类型
    protected String weaponType;
    //最佳类型武器
    protected String bestWeaponType;
    //特殊角色共同属性，装备了角色武器则能触发特殊攻击
    protected Boolean hasSpecialAtk = false;

    public SpecialRole(String name, int hp, int damage) {
        super( name, hp, damage);
        //默认初始的特殊角色的出生装备
        weapon = new Weapon( "赤拳", 0);
        armor = new Armor( "秋裤", 0);
    }
    public boolean getSpecialAtk() {
        return hasSpecialAtk;
    }

    public void setSpecialAtk(Boolean option) {
        this.hasSpecialAtk = option;
    }

    public void equipWeapen(Weapon weapon) {
        if (weaponType.contains(weapon.getWeaponType())) {
            this.weapon = weapon;
            this.damage += weapon.getDamage();

            if (bestWeaponType.equals( weapon.getWeaponType() )) {
                hasSpecialAtk = true;
            }

        }else {
            System.out.println(getName() + "无法装备" + weapon.getName());
        }
    }

    public void unequipWeapen() {
        damage -= weapon.getDamage();
        hasSpecialAtk = false;
        this.weapon = new Weapon( "徒手", 0 );
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public String attack(AveragePerson theDefender) {
        if(debuff.isTriggerDebuff()) {
            boolean isStun = debuff.settleDebuf( this );
            if (isStun) {
                return "";
            }
        }
        return String.format("%s%s用%s攻击了%s%s，", getRole(), getName(), weapon.getName(), theDefender.getRole(), theDefender.getName());
    }

    public String beAttacked(AveragePerson theAttacker) {
        Weapon weaponBuf = theAttacker.weapon;
        Random random = new Random();
        int atkDamage = 0;

        if (!theAttacker.isStun) {

            atkDamage = theAttacker.getDamage() - armor.getDefense();
            atkDamage = atkDamage > 0 ? atkDamage : 0;

            if ((weaponBuf != null) && (weaponBuf.judgePorc( random ) && theAttacker.getSpecialAtk()) ) {

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
