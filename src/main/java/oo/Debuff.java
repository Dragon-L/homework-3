package oo;

public class Debuff {
    private String debuffname;
    private int debuffdamage;
    private int remaincounts;
    private boolean iseffect;           //当轮是否发动效果（for冰冻）

    public Debuff(WeaponFeature weaponFeature){
        this.debuffname = weaponFeature.getFeatureName();
        this.debuffdamage = weaponFeature.getDamage();
        this.remaincounts = weaponFeature.getCounts();
        this.iseffect = true;
    }
    public Debuff(){
        this.debuffdamage = 0;
        this.debuffname = "";
        this.remaincounts = 0;
        this.iseffect = false;
    }

    public String getDebuffname(){ return debuffname; }
    public int getDebuffdamage(){ return debuffdamage; }
    public int getRemaincounts(){ return remaincounts; }
    public boolean getIsEffect(){ return iseffect; }
    public void setIseffect(boolean bool){ this.iseffect = bool; }
    public void setRemaincounts(int counts){
        this.remaincounts = counts;
    }
}
