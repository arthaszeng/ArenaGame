import weapon.Weapon;

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
        if (!theAttacker.isStun) {
            if (armor.getDefense() <= theAttacker.getDamage()) {
                hp -= theAttacker.getDamage() - armor.getDefense();
                return String.format( "%s受到了%d点伤害，%s剩余生命：%d",
                        getName(), theAttacker.damage - armor.getDefense(), getName(), getHp() );
            } else {
                return String.format( "%s受到了%d点伤害，%s剩余生命：%d",
                        getName(), 0, getName(), getHp() );
            }
        }else{
            theAttacker.isStun = false;
            return "";
        }
    }

}
