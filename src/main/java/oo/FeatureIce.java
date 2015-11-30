package oo;

public class FeatureIce extends WeaponFeature {
    private final int counts;

    public FeatureIce(int counts){
        super("冰冻");
        this.counts = counts;
    }
    @Override
    public int getDamage() {
        return 0;
    }
    @Override
    public int getCounts() { return counts; }
}
