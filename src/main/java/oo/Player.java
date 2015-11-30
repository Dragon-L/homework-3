package oo;

import static java.lang.String.format;

public class Player {
    private String name;
    private int blood;
    private int damage;
    private String job;
    private boolean isdebuff;
    private Debuff debuff;

    public Player(String name, int blood, int damage,String job) {
        this.name = name;
        this.blood = blood;
        this.damage = damage;
        this.job = job;
        this.isdebuff = false;
        this.debuff = new Debuff();
    }
    public String getName() {
        return name;
    }
    public int getBlood() {
        return blood;
    }
    public int getDamage() {
        return damage;
    }
    public String getJob() {
        return this.job;
    }
    public boolean getIsDebuff(){ return isdebuff; }
    public String getDebuffName(){ return debuff.getDebuffname(); }

    public String attack(Player victim) {
        return format("%s%s攻击了%s%s，%s",job,name,victim.getJob(),victim.getName(), victim.beAttacked(damage));
    }
    public String beAttacked(int damage) {
        blood -= damage;
        return format("%s受到了%d点伤害，%s剩余生命：%d",
                name, damage, name, blood);
    }
    public boolean isAlive() {
        return blood >= 0;
    }

    public void beDebuff(WeaponFeature weaponFeature){    // 被上debuff
        if (debuff.getRemaincounts()<=0){                 //第一次被上debuff
            debuff = new Debuff(weaponFeature);
        }
        else {
            debuff.setRemaincounts(debuff.getRemaincounts()+weaponFeature.getCounts());  //debuff叠加
        }
        isdebuff = true;
    }
    public String debuff(){
        if(debuff.getDebuffname().equals("毒性")||debuff.getDebuffname().equals("火焰")){
            debuffRemainCountsReduceOne();
            blood -= debuff.getDebuffdamage();
            return format("%s受到了%d点%s伤害，%s剩余生命值：%d\n",name,debuff.getDebuffdamage(),debuff.getDebuffname(),name,blood);
        }
        else if (debuff.getDebuffname().equals("冰冻")){
            if (debuff.getIsEffect()){
                debuffRemainCountsReduceOne();
                debuff.setIseffect(false);
                return format("%s被冰冻了，无法攻击，冰冻还剩：%d轮\n",name,debuff.getRemaincounts());
            }
            else {
                debuff.setIseffect(true);
                return "";
            }
        }
        else if (debuff.getDebuffname().equals("击晕")){
            debuffRemainCountsReduceOne();
            return format("%s晕倒了，无法攻击，眩晕还剩：%d轮\n",name,debuff.getRemaincounts());
        }
        return "";
    }

    private void debuffRemainCountsReduceOne() {
        debuff.setRemaincounts(debuff.getRemaincounts()-1);
        isdebuff = (debuff.getRemaincounts()>0);
    }
}
