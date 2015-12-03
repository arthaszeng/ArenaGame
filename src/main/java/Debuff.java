public class Debuff {
    private String debuffName;
    private int restRounds;
    private int debuffDamage;

    public Debuff(String debuffName, int restRounds, int debuffDamage){
        this.debuffDamage = debuffDamage;
        this.debuffName = debuffName;
        this.restRounds = restRounds;
    }

    public int getRestRounds() {
        return restRounds;
    }

    public int getDebuffDamage() {
        return debuffDamage;
    }

    public boolean settleDebuf(Player player){
        if (restRounds-- > 0 ){
            switch (debuffName){
                case "中毒" :{
                    poisonAtk( player );
                    return false;
                }
                case "被眩晕" :{
                    stunAtk( player );
                    return true;
                }
                case "被暴击" :{
                    critAtk(player);
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isTriggerDebuff() {
        if (restRounds > 0)
            return true;
        else
            return false;
    }

    public void poisonAtk(Player player) {
        player.setHp(player.getHp() - debuffDamage);
        System.out.println(player.getName() + "受到了" + debuffDamage + "毒性攻击，" + player.getName() + "剩余生命值：" + player.getHp());
    }

    public void stunAtk(Player player) {
        System.out.println(player.getName() + "被眩晕了，不能攻击，剩余眩晕回合：" + restRounds);
    }

    public void critAtk(Player player) {

    }
}
