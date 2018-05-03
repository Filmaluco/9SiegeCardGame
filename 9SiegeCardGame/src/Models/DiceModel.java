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

    /**
     * Changes the dice (DRM) depending on the card rule
     * @param target_rule Card rule code
     */
    public DiceModel(int target_rule){

        //The next piece of code is a sample:
        //one target can change only a flag
        if(target_rule == rule.IRON_SHIELDS){ this.modifier = -1; siege_tower = true;}
        // or multiple
        if(target_rule == rule.COVER_OF_DARKNESS){ this.modifier = 1; raid = true; sabotage = true;}
        //....

        //TODO: comple for all rules
    }

    /**
     *
     * @param target_roll Enemy unit code to attack
     * @return DRM value for specific Enemy Target
     */
    public int roll(int target_roll){
        int roll = roll();

        //TODO: Apply same logic to all others
        if(target_roll == roll_for.BOILING_ATTACK_SIEGETOWER && siege_tower) {roll += modifier;}



        roll = roll > 6 ? 6 : roll;
        roll = roll < 0 ? 0 : roll;
        return roll;
    }

    /**
     *
     * @return Random number from 1 to 6
     */
    public int roll(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }


}
