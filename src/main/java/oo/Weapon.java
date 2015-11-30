package oo;

public class Weapon {
    private String weaponname;                 //名字
    private int weapondamage;                   //伤害
    private boolean havefeature;                //是否有特性
    private WeaponFeature weaponfeature;        //特性
    private double odds;                        //特性触发几率
    private String weapontype;                  //武器类型：长、短、中


    public Weapon(String weaponname, int weapondamage,WeaponFeature weaponfeature,double odds,String weapontype) {   //武器构造函数：名字 伤害 特性 触发几率 类型
        this.weapondamage = weapondamage;
        this.weaponname = weaponname;
        this.havefeature = true;
        this.weaponfeature = weaponfeature;
        assert(odds>=0&&odds<=1);
        this.odds = odds;
        this.weapontype = weapontype;
    }
    public Weapon(String weaponname, int weapondamage,String weapontype) {
        this.weapondamage = weapondamage;
        this.weaponname = weaponname;
        this.havefeature = false;
        this.weapontype = weapontype;
    }
    public Weapon(){
    }


    public String getname() {
        return weaponname;
    }
    public int getdamage() {
        return weapondamage;
    }
    public boolean isHavefeature(){ return havefeature;}
    public WeaponFeature getWeaponfeature(){ return weaponfeature; }
    public double getOdds(){ return odds; }
    public String getWeapontype(){ return weapontype; }
}
