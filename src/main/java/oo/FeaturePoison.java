package oo;

public class FeaturePoison extends WeaponFeature{
    private final int damage;
    private final int counts;

    public FeaturePoison(int damage,int counts){
        super("毒性");
        this.damage = damage;
        this.counts = counts;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getCounts() {
        return counts;
    }
}
