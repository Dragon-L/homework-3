package oo;

import static java.lang.String.format;

public class Worrior extends Soldier {
    public Worrior(String name, int blood, int damage, Weapon weapon, Armor armor){
        super(name,blood,damage,"战士",weapon,armor);
        assert (weapon.getWeapontype().equals("中"));
    }
    public Worrior(String name, int blood, int damage, Weapon weapon){
        super(name,blood,damage,"战士",weapon);
        assert (weapon.getWeapontype().equals("中"));
    }
    public Worrior(String name, int blood, int damage, Armor armor){
        super(name,blood,damage,"战士",armor);
    }
    public Worrior(String name, int blood, int damage){
        super(name,blood,damage,"战士");
    }
    @Override
    public String attack(Player victim) {  //战士只有装备中武器触发效果
        if (this.getWeaponType().equals("短")||this.getWeaponType().equals("长")){
            return format("%s%s用%s攻击了%s%s，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
        }
        return super.attack(victim);
    }
}
