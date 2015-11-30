package oo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WeaponTest {
    @Test
    public void should_create_weapon_withno_feature_successfully() {
        Weapon weapon = new Weapon("优质木棒",10,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
    }
    @Test
    public void should_create_weapon_with_feature_poison_successfully() {
        WeaponFeature poison = new FeaturePoison(10,3);
        Weapon weapon = new Weapon("优质木棒",10,poison,0.3,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
        assertThat(weapon.getWeaponfeature().getFeatureName(),is("毒性"));
    }
    @Test
    public void should_create_weapon_with_feature_fire_successfully() {
        WeaponFeature poison = new FeatureFire(10,3);
        Weapon weapon = new Weapon("优质木棒",10,poison,0.5,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
        assertThat(weapon.getWeaponfeature().getFeatureName(),is("火焰"));
    }
    @Test
    public void should_create_weapon_with_feature_ice_successfully() {
        WeaponFeature poison = new FeatureIce(3);
        Weapon weapon = new Weapon("优质木棒",10,poison,0.5,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
        assertThat(weapon.getWeaponfeature().getFeatureName(),is("冰冻"));
    }
    @Test
    public void should_create_weapon_with_feature_stun_successfully() {
        WeaponFeature poison = new FeatureStun();
        Weapon weapon = new Weapon("优质木棒",10,poison,0.5,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
        assertThat(weapon.getWeaponfeature().getFeatureName(),is("击晕"));
    }
    @Test
    public void should_create_weapon_with_feature_crit_successfully() {
        WeaponFeature poison = new FeatureCrite();
        Weapon weapon = new Weapon("优质木棒",10,poison,0.5,"长");

        assertThat(weapon.getname(),is("优质木棒"));
        assertThat(weapon.getdamage(),is(10));
        assertThat(weapon.getWeaponfeature().getFeatureName(),is("暴击"));
    }
}
