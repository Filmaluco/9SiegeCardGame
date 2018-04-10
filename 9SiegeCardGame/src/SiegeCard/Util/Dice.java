package SiegeCard.Util;

import java.util.Random;

public class Dice {

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

    public Dice(int target_rule, int modifier){

        this.modifier = modifier;
        //The next piece of code is a sample:
        //one target can change only a flag
        if(target_rule == rule.REPAIRED_TREBUCHET){ coupure = true;}
        // or multiple
        if(target_rule == rule.COVER_OF_DARKNESS){ raid = true; sabotage = true;}
        //....

        //TODO: comple for all rules
    }

    public int roll(int target_roll){
        Random r = new Random();
        int roll = r.nextInt(6);

        //TODO: Apply same logic to all others
        if(target_roll == roll_for.COUPURE_ROLL && coupure) {roll += modifier;}



        roll = roll > 6 ? 6 : roll;
        roll = roll < 0 ? 0 : roll;
        return roll;
    }

    public int roll(){
        Random r = new Random();
        return r.nextInt(6);
    }


}
