package oo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void should_Create_Player_Successfully() {
        Player player = new Player("王二麻子", 100, 10,"普通人");

        assertThat(player.getName(), is("王二麻子"));
        assertThat(player.getBlood(), is(100));
        assertThat(player.getDamage(), is(10));
        assertThat(player.getJob(),is("普通人"));
    }


    @Test
    public void should_return_who_attack_victim_and_how_much_victim_bleed_and_how_much_blood_left_when_player_fight_player() {
        Player attacker = new Player("张三", 100, 10,"普通人");
        Player victim = new Player("李四", 80, 20,"普通人");

        assertThat(attacker.attack(victim), is("普通人张三攻击了普通人李四，李四受到了10点伤害，李四剩余生命：70"));
    }
    @Test
    public void should_return_who_attack_victim_and_how_much_victim_bleed_and_how_much_blood_left_when_player_fight_soldier() {
        Player attacker = new Player("张三", 100, 10,"普通人");
        Armor armor = new Armor(5);
        Player victim = new Soldier("李四", 80, 20,"战士",armor);

        assertThat(attacker.attack(victim), is("普通人张三攻击了战士李四，李四受到了5点伤害，李四剩余生命：75"));
    }

    @Test
    public void should_Alive_When_Blood_Is_0() {
        Player survivor = new Player("王二麻子", 0, 0,"普通人");

        assertThat(survivor.isAlive(), is(true));
    }

    @Test
    public void should_Alive_When_Blood_Great_Than_0() {
        Player survivor = new Player("王二麻子", 1, 0,"普通人");

        assertThat(survivor.isAlive(), is(true));
    }

    @Test
    public void should_Dead_When_Blood_Less_Than_0() {
        Player dead = new Player("王二麻子", -1, 0,"普通人");

        assertThat(dead.isAlive(), is(false));
    }
}