package oo;

import static java.lang.String.format;

public class Game {
    private ConsolePrinter consolePrinter;

    public Game(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void fight(Player firstPlayer, Player secondPlayer) {
        Player attacker = firstPlayer;
        Player victim = secondPlayer;
        Player loser = attacker;

        while (attacker.isAlive()) {
            switch (debuff(attacker)){  //攻击前检查攻击者身上的debuff，1表示被击晕或者冰冻;2表示受到伤害
                case 1:     //跳过攻击回合
                    loser = victim;
                    victim = attacker;
                    attacker = loser;
                    break;
                case 2:     //检查是否死亡
                    if (!attacker.isAlive()){ break; }
                default:
                    consolePrinter.print(format("%s\n", attacker.attack(victim)));
                    loser = victim;
                    victim = attacker;
                    attacker = loser;
            }
        }
        consolePrinter.print(format("%s被打败了", loser.getName()));
    }

    public int debuff(Player player) {
        if (player.getIsDebuff()) {           //如果身上有debuff
            if (player.getDebuffName().equals("毒性") || player.getDebuffName().equals("火焰")) {
                consolePrinter.print(format("%s", player.debuff()));
                return 2;
            }
            else if (player.getDebuffName().equals("击晕")){
                consolePrinter.print(format("%s",player.debuff()));
                return 1;
            }
            else if (player.getDebuffName().equals("冰冻")){
                String temp = player.debuff();
                if (temp.equals("")){
                    return 0;
                }
                else {
                    consolePrinter.print(temp);
                    return 1;
                }
            }
        }
        return 0;
    }
}
