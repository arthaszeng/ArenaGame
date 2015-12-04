package player;

import weapon.Weapon;

import java.util.Random;

public class AveragePerson {
    private String name;
    protected int hp;
    protected int damage;
    protected boolean isStun = false; //这回合是否晕眩
    protected Debuff debuff = new Debuff( "无", 0, 0);
    protected Weapon weapon = null;
    protected String role = "普通人";

    public AveragePerson(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getRole() { return this.role; }

    public void setName(String name) {
        this.name = name ;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamag(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        if (hp > 0) {
            return true;
        }else{
            return false;
        }
    }

    public String beAttacked(AveragePerson theAttacker) {
        Random random = new Random();
        Weapon weaponBuf = theAttacker.weapon;
        int atkDamage;
        if (weaponBuf != null && weaponBuf.judgePorc(random)) {
            if(weaponBuf.getProcName().equals( "被暴击" )){
                this.debuff = new Debuff( "被暴击", 0, 0);
                atkDamage = theAttacker.getDamage() * 3;
            }else{
                this.debuff = new Debuff( weaponBuf.getProcName(), weaponBuf.getAtkRounds() + this.debuff.getRestRounds(), weaponBuf.getProcDamage() );
                atkDamage = theAttacker.getDamage();
            }
            hp -= atkDamage;
            return String.format( "%s受到了%d点伤害，%s%s了，%s剩余生命：%d",
                    getName(), atkDamage, getName(), weaponBuf.getProcName(), getName(), getHp() );
        }else{
            int damageOfAttacker = theAttacker.getDamage();
            hp -= damageOfAttacker;
            return String.format( "%s受到了%d点伤害，%s剩余生命：%d",
                    getName(), damageOfAttacker, getName(), getHp() );
        }
    }

    public String attack(AveragePerson theDefender) {
        if(debuff.isTriggerDebuff()) {
            if (debuff.settleDebuf(this)){
                isStun = true;
                return "";
            }
        }
        return String.format( "%s%s攻击了%s%s，", getRole(), getName(), theDefender.getRole(), theDefender.getName() );
    }

}
