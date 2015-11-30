package oo;

public class FeatureFire extends WeaponFeature {
    private final int damage;
    private final int counts;

    public FeatureFire(int damage,int counts) {
        super("火焰");
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
