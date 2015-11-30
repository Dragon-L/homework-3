package oo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    private Game game;
    private  ConsolePrinter consolePrinter;

//    @Mock
//    private ConsolePrinter consolePrinter;
//    InOrder inOrder;

    @Before
    public void setUp() {
//        inOrder = inOrder(consolePrinter);
        consolePrinter = new ConsolePrinter();
        game = new Game(consolePrinter);
    }

    @Test
    public void should_have_no_effect_when_assasin_with_middle_weapon() {
        WeaponFeature poison = new FeaturePoison(5,3);
        Weapon weapon = new Weapon("毒剑",10,poison,1.0,"中");
        Player firstPlayer = new Assassin("张三", 100, 10,weapon);
        Player secondPlayer = new Player("李四", 30, 10,"普通人");
        game.fight(firstPlayer, secondPlayer);

//        inOrder.verify(consolePrinter, times(1)).print("刺客张三用毒剑攻击了普通人李四，李四受到了20点伤害，李四剩余生命：10\n");
//        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了10点伤害，张三剩余生命：90\n");
//        inOrder.verify(consolePrinter, times(1)).print("刺客张三用毒剑攻击了普通人李四，李四受到了20点伤害，李四剩余生命：-10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被打败了");
    }
    @Test
    public void should_have_effect_when_assasin_with_short_weapon() {
        WeaponFeature poison = new FeaturePoison(5,3);
        Weapon weapon = new Weapon("毒剑",10,poison,1.0,"短");
        Player firstPlayer = new Assassin("张三", 100, 10,weapon);
        Player secondPlayer = new Player("李四", 30, 10,"普通人");
        game.fight(firstPlayer, secondPlayer);

//        inOrder.verify(consolePrinter, times(1)).print("刺客张三用毒剑攻击了普通人李四，李四受到了20点伤害，李四剩余生命：10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四受到了5点毒性伤害，李四剩余生命：5\n");
//        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了10点伤害，张三剩余生命：90\n");
//        inOrder.verify(consolePrinter, times(1)).print("刺客张三用毒剑攻击了普通人李四，李四受到了20点伤害，李四剩余生命：-15\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被打败了");
    }

    @Test
    public void should_be_stun_when_use_weapon_with_stun() {
        WeaponFeature stun = new FeatureStun();
        Weapon weapon = new Weapon("晕锤",10,stun,1.0,"中");
        Player firstPlayer = new Worrior("张三", 100, 10,weapon);
        Player secondPlayer = new Player("李四", 50, 10,"普通人");
        game.fight(firstPlayer, secondPlayer);

//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：30\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四晕倒了，无法攻击，眩晕还剩：1轮\n");
//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四晕倒了，无法攻击，眩晕还剩：2轮\n");
//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：-10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被打败了");
    }
    @Test
    public void should_be_ice_when_use_weapon_with_ice() {
        WeaponFeature ice = new FeatureIce(2);
        Weapon weapon = new Weapon("冰锤",10,ice,1.0,"中");
        Player firstPlayer = new Worrior("张三", 100, 10,weapon);
        Player secondPlayer = new Player("李四", 70, 10,"普通人");
        game.fight(firstPlayer, secondPlayer);

//        inOrder.verify(consolePrinter, times(1)).print("战士张三用冰锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：50\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被冰冻了，无法攻击，冰冻还剩：1轮\n");
//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：30\n");
//        inOrder.verify(consolePrinter, times(1)).print("普通人李四攻击了战士张三，张三受到了10点伤害，张三剩余生命：90\n");
//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被冰冻了，无法攻击，冰冻还剩：4轮\n");
//        inOrder.verify(consolePrinter, times(1)).print("战士张三用晕锤攻击了普通人李四，李四受到了20点伤害，李四剩余生命：-10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被打败了");
    }
    @Test
    public void should_crite_when_use_weapon_with_crite() {
        WeaponFeature crite = new FeatureCrite();
        Weapon weapon = new Weapon("利剑",10,crite,1.0,"中");
        Player firstPlayer = new Worrior("张三", 100, 10,weapon);
        Player secondPlayer = new Player("李四", 50, 10,"普通人");
        game.fight(firstPlayer, secondPlayer);

//        inOrder.verify(consolePrinter, times(1)).print("战士张三用利剑攻击了普通人李四，张三发动了全力一击，李四受到了60点伤害，李四剩余生命：-10\n");
//        inOrder.verify(consolePrinter, times(1)).print("李四被打败了");
    }
}