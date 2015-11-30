package oo;

import javax.lang.model.type.NullType;

import java.util.Random;

import static java.lang.String.format;

public class Soldier extends Player{    //士兵类，用于派生3个职业：战士、刺客、骑士

    private final Weapon weapon;    //装备的武器
    private final Armor armor;      //装备的防具

    public Soldier(String name, int blood, int damage, String job, Weapon weapon, Armor armor) { //构造函数重载
        super(name,blood,damage,job);
        this.weapon = weapon;
        this.armor = armor;
    }
    public Soldier(String name, int blood, int damage, String job,Weapon weapon){
        super(name,blood,damage,job);
        this.weapon = weapon;
        this.armor = new Armor(0);
    }
    public Soldier(String name, int blood, int damage, String job,Armor armor){
        super(name,blood,damage,job);
        this.weapon = new Weapon();
        this.armor = armor;
    }
    public Soldier(String name, int blood, int damage, String job){
        super(name,blood,damage,job);
        this.weapon = new Weapon();
        this.armor = new Armor(0);
    }

    public int getDefense() { return this.armor.getdefense(); }
    public String getWeaponName() {
        return weapon.getname();
    }
    public String getWeaponType(){ return weapon.getWeapontype(); }
    @Override
    public int getDamage() {
        return super.getDamage()+weapon.getdamage();
    }
    @Override
    public String attack(Player victim) {
        if(weapon.getname().equals("")){                              //没有装备武器时
            return format("%s%s攻击了%s%s，%s",this.getJob(),this.getName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
        }
        else if(weapon.isHavefeature()&&isTrigger(weapon.getOdds())){  //装备特性武器并且触发特性时
            if (weapon.getWeaponfeature().getFeatureName().equals("暴击")){
                return format("%s%s用%s攻击了%s%s，%s发动了全力一击，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),this.getName(),victim.beAttacked(this.getDamage()*3));
            }
            else {
                victim.beDebuff(weapon.getWeaponfeature());
                return format("%s%s用%s攻击了%s%s，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
            }
        }
        else {                                                        //装备无特性武器或者特性没触发时
            return format("%s%s用%s攻击了%s%s，%s",this.getJob(),this.getName(),this.getWeaponName(),victim.getJob(),victim.getName(),victim.beAttacked(this.getDamage()));
        }
    }

    private boolean isTrigger(double odds) {  //是否有触发武器特效
        Random r = new Random();
        return (r.nextDouble()<odds);
    }

    @Override
    public String beAttacked(int damage) {
        int temp = damage - armor.getdefense();
        int hurt = (temp>0?temp:0);
        return super.beAttacked(hurt);
    }
}
