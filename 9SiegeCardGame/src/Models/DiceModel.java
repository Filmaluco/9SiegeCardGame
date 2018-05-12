package Models;

import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

import java.util.Random;

public class DiceModel implements rolls, rules {

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
     * Changes the dice (DRM) depending on the card rules
     * @param target_rule Card rules code
     */
    public DiceModel(int target_rule){

        //TODO: comple for all
        switch (target_rule){

            case ILLNESS: { modifier = 0; break;}
            case GUARDS_DISTRACTED: { modifier = +1; sabotage = true; rally = true; break;}

            default: //Exeption
        }

    }

    /**
     * @param target_roll Enemy unit code to attack
     * @return DRM value for specific Enemy Target
     */
    public int roll(int target_roll){
        int rolled = roll();

        switch (target_roll){
            case BOILING_ATTACK_SIEGETOWER: { rolled = siege_tower ? rolled+= modifier: rolled; break;}
            case SABOTAGE_ROLL: { rolled = sabotage ? rolled+= modifier: rolled; break;}
            case RALLY_TROOPS: { rolled = rally ? rolled+= modifier: rolled; break;}
        }

        rolled = rolled > 6 ? 6 : rolled;
        rolled = rolled < 0 ? 0 : rolled;
        return rolled;
    }

    private int roll(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }


}
