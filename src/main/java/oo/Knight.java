package oo;

import static java.lang.String.format;

public class Knight extends Soldier {
    public Knight(String name, int blood, int damage,  Weapon weapon, Armor armor){
        super(name,blood,damage,"骑士",weapon,armor);
        assert (weapon.getWeapontype().equals("中")||weapon.getWeapontype().equals("长"));
    }
    public Knight(String name, int blood, int damage, Weapon weapon){
        super(name,blood,damage,"骑士",weapon);
        assert (weapon.getWeapontype().equals("中")||weapon.getWeapontype().equals("长"));
    }
    public Knight(String name, int blood, int damage, Armor armor){
        super(name,blood,damage,"骑士",armor);
    }
    public Knight(String name, int blood, int damage){
        super(name,blood,damage,"骑士");
    }
    @Override
    public String attack(Player victim) {  //骑士只有装备长武器触发效果
        if (this.getWeaponType().equals("中")||this.getWeaponType().equals("短")){
            return format("%s%s用%s攻击了%s%s，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
        }
        return super.attack(victim);
    }
}
