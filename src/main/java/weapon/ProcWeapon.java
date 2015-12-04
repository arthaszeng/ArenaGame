package weapon;

import java.util.Random;

public class ProcWeapon extends Weapon {
    protected String procName;
    protected int atkRounds;
    protected int procDamge;
    protected double rate;

//长短武器属性
    protected String weaponType;

    private GetRandom getRandom;        //////////这里是否应该传进来？

    public ProcWeapon(String name, int damage, int charactorDamge, int atkRounds, double rate) {
        super( name, damage );
        this.atkRounds = atkRounds;
        this.procDamge = charactorDamge;
        this.rate = rate;
    }

    public String getProcName() {
        return procName;
    }

    public int getAtkRounds() {
        return atkRounds;
    }

    public int getProcDamage() {
        return procDamge;
    }

    public String getWeaponType() { return weaponType;}

    public double getRate() {
        return rate;
    }

    public void setAtkRounds(int restRounds) {
        atkRounds = restRounds;
    }

    public void setRate(double newRate) {
        rate = newRate;
    }

    public boolean judgePorc(Random random) {
        int rateNumber = (int)(rate * 100);
        getRandom = new GetRandom( random );
         if (100 - rateNumber > getRandom.getNumber()){
             return false;
         }else {
             return true;
         }
    }
}
