package oo;

import static java.lang.String.format;

public class Assassin extends Soldier {
    public Assassin(String name, int blood, int damage, Weapon weapon, Armor armor){
        super(name,blood,damage,"刺客",weapon,armor);
        assert (weapon.getWeapontype().equals("中")||weapon.getWeapontype().equals("短"));
    }
    public Assassin(String name, int blood, int damage, Weapon weapon){
        super(name,blood,damage,"刺客",weapon);
        assert (weapon.getWeapontype().equals("中")||weapon.getWeapontype().equals("短"));
    }
    public Assassin(String name, int blood, int damage, Armor armor){
        super(name,blood,damage,"刺客",armor);
    }
    public Assassin(String name, int blood, int damage){
        super(name,blood,damage,"刺客");
    }

    @Override
    public String attack(Player victim) {  //刺客只有装备短武器触发效果
        if (this.getWeaponType().equals("中")||this.getWeaponType().equals("长")){
            return format("%s%s用%s攻击了%s%s，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
        }
        return super.attack(victim);
    }
}
