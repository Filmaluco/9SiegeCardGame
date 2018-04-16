package Models;

import SiegeCard.Util.roll_for;
import SiegeCard.Util.rule;

import java.util.Random;

public class DiceModel {

    private boolean close_combat_attack = false,
                    normal_attack = false,
                    circle_attack = false,
                    battering_ram = false,
                    ladder = false,
                    siege_tower = false,
                    supplies = false,
                    sabotage = false,
                    raid = false,
                    rally = false,
                    coupure = false;

    private int modifier;

    public DiceModel(int target_rule){

        //The next piece of code is a sample:
        //one target can change only a flag
        if(target_rule == rule.IRON_SHIELDS){ this.modifier = -1; siege_tower = true;}
        // or multiple
        if(target_rule == rule.COVER_OF_DARKNESS){ this.modifier = 1; raid = true; sabotage = true;}
        //....

        //TODO: comple for all rules
    }

    public int roll(int target_roll){
        Random r = new Random();
        int roll = r.nextInt(6);

        //TODO: Apply same logic to all others
        if(target_roll == roll_for.BOILING_ATTACK_SIEGETOWER && siege_tower) {roll += modifier;}



        roll = roll > 6 ? 6 : roll;
        roll = roll < 0 ? 0 : roll;
        return roll;
    }

    public int roll(){
        Random r = new Random();
        return r.nextInt(6);
    }


}
