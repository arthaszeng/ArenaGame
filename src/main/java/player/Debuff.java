package player;

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

    public boolean settleDebuf(AveragePerson averagePerson){
        if (restRounds-- > 0 ){
            switch (debuffName){
                case "中毒" :{
                    poisonAtk( averagePerson );
                    return false;
                }
                case "被眩晕" :{
                    stunAtk( averagePerson );
                    return true;
                }
                case "被暴击" :{
                    critAtk( averagePerson );
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

    public void poisonAtk(AveragePerson averagePerson) {
        averagePerson.setHp( averagePerson.getHp() - debuffDamage);
        System.out.println( averagePerson.getName() + "受到了" + debuffDamage + "毒性攻击，" + averagePerson.getName() + "剩余生命值：" + averagePerson.getHp());
    }

    public void stunAtk(AveragePerson averagePerson) {
        averagePerson.isStun = true;
        System.out.println( averagePerson.getName() + "被眩晕了，不能攻击，剩余眩晕回合：" + restRounds);
    }

    public void critAtk(AveragePerson averagePerson) {

    }
}
