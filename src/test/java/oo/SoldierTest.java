package oo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SoldierTest {
    @Test
    public void should_create_soldier_successfully_when_equipment_weapon_and_armor() {
        Weapon weapon = new Weapon("优质木棒",10,"中");
        Armor armor = new Armor(5);
        Soldier soldier = new Soldier("张三",100,10,"战士",weapon,armor);

        assertThat(soldier.getName(),is("张三"));
        assertThat(soldier.getBlood(),is(100));
        assertThat(soldier.getDamage(),is(20));
        assertThat(soldier.getDefense(),is(5));
        assertThat(soldier.getJob(),is("战士"));
    }
    @Test
    public void should_create_soldier_successfully_when_equipment_nothing() {
        Soldier soldier = new Soldier("张三",100,10,"战士");

        assertThat(soldier.getName(),is("张三"));
        assertThat(soldier.getBlood(),is(100));
        assertThat(soldier.getDamage(),is(10));
        assertThat(soldier.getJob(),is("战士"));
    }
    @Test
    public void should_return_who_attack_victim_and_how_much_victim_bleed_and_how_much_blood_left_when_soldier_with_weapon_fight_player() {
        Weapon weapon = new Weapon("优质木棒",10,"中");
        Player attacker = new Soldier("张三",100,10,"战士",weapon);
        Player victim = new Player("李四",100,5,"普通人");

        assertThat(attacker.attack(victim),is("战士张三用优质木棒攻击了普通人李四，李四受到了20点伤害，李四剩余生命：80"));
    }
    @Test
    public void should_return_who_attack_victim_and_how_much_victim_bleed_and_how_much_blood_left_when_soldier_withno_weapon_fight_player() {
        Player attacker = new Soldier("张三",100,10,"战士");
        Player victim = new Player("李四",100,5,"普通人");
        assertThat(attacker.attack(victim),is("战士张三攻击了普通人李四，李四受到了10点伤害，李四剩余生命：90"));
    }
    @Test
    public void should_return_who_attack_victim_and_how_much_victim_bleed_and_how_much_blood_left_when_soldier_with_weapon_fight_soldier_with_armor() {
        Weapon weapon = new Weapon("优质木棒",10,"中");
        Player attacker = new Soldier("张三",100,10,"战士",weapon);
        Armor armor = new Armor(5);
        Player victim = new Soldier("李四",100,10,"战士",armor);

        assertThat(attacker.attack(victim),is("战士张三用优质木棒攻击了战士李四，李四受到了15点伤害，李四剩余生命：85"));
    }
}
