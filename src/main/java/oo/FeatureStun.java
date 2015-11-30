package oo;

public class FeatureStun extends WeaponFeature {
    public FeatureStun(){
        super("击晕");
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getCounts() {
        return 2;
    }
}
