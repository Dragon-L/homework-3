package oo;

public class FeatureCrite extends WeaponFeature {
    public FeatureCrite() {
        super("暴击");
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getCounts() {
        return 1;
    }
}
