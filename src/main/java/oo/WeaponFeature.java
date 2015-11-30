package oo;

abstract class WeaponFeature {        //抽象类，用于4种武器特性类继承
    private String featureName;         //特性名字：火焰、冰冻、毒性、击晕
    public WeaponFeature(String featureName){
        this.featureName = featureName;
    }

    public String getFeatureName(){ return this.featureName; }
    abstract int getDamage();
    abstract int getCounts();           //返回特性持续回合数

}
