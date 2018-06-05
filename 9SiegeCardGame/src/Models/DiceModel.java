package Models;

import SiegeCard.Util.*;

import java.io.Serializable;
import java.util.Random;

public class DiceModel implements rolls, rules, Serializable {

    private boolean normal_attack = false,
                    circle_attack = false,
                    close_combat = false,
                    battering_ram = false,
                    ladder = false,
                    siege_tower = false,
                    sabotage = false,
                    raid = false,
                    rally = false,
                    coupure = false;

    private int     modifier = 0;
    private int     lastRoll = 0;

    /**
     * Changes the dice (DRM) depending on the card rules
     * @param target_rule Card rules code
     */
    public DiceModel(int target_rule){

        switch (target_rule){

            case TREBUCHET_ATTACK: {        modifier = 0;
                                            break;}

            case ILLNESS: {                 modifier = 0;
                                            break;}

            case GUARDS_DISTRACTED: {       modifier = 1;
                                            sabotage = true;
                                            rally = true;
                                            break;}

            case SUPPLIES_SPOILED: {        modifier = 0;
                                            break;}

            case BAD_WEATHER: {             modifier = 0;
                                            break;}

            case BOILING_OIL: {             modifier = 2;
                                            circle_attack=true;
                                            break;}

            case DEATH_OF_A_LEADER: {       modifier = 0;
                                            break;}

            case GATE_FORTIFIED: {          modifier = 1;
                                            normal_attack = true;
                                            circle_attack = true;
                                            battering_ram = true;
                                            break;}

            case FLAMING_ARROWS: {          modifier = 1;
                                            normal_attack = true;
                                            circle_attack = true;
                                            siege_tower = true;
                                            break;}

            case VOLLEY_OF_ARROWS: {        modifier = 1;
                                            battering_ram = true;
                                            siege_tower = true;
                                            ladder = true;
                                            normal_attack = true;
                                            circle_attack = true;
                                            break;}

            case COLLAPSED: {               modifier = 0;
                                            break;}

            case REPAIRED_TREBUCHET: {      modifier = 1;
                                            coupure = true;
                                            break;}

            case COVER_OF_DARKNESS: {       modifier = 1;
                                            raid = true;
                                            sabotage = true;
                                            break;}

            case ENEMY_FATIGUE: {           modifier = 1;
                                            coupure = true;
                                            raid = true;
                                            sabotage = true;
                                            break;}

            case RALLY: {                   modifier = 1;
                                            circle_attack = true;
                                            close_combat = true;
                                            break;}

            case DETERMINED_ENEMY: {        modifier = -1;
                                            normal_attack = true;
                                            circle_attack = true;
                                            battering_ram = true;
                                            break;}

            case IRON_SHIELDS: {            modifier = -1;
                                            siege_tower = true;
                                            normal_attack = true;
                                            circle_attack = true;
                                            break;}

            case FAITH: {                   modifier = 1;
                                            battering_ram = true;
                                            ladder = true;
                                            rally = true;
                                            normal_attack = true;
                                            circle_attack = true;
                                            break;}


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
            case NORMAL_ATTACK_BATTERING_RAM:{  rolled = battering_ram && normal_attack ? rolled+ modifier: rolled; break;}
            case NORMAL_ATTACK_LADDER:{         rolled = ladder && normal_attack ? rolled+ modifier: rolled; break;}
            case NORMAL_ATTACK_SIEGETOWER:{     rolled = siege_tower && normal_attack ? rolled+ modifier: rolled; break;}
            case CIRCLE_ATTACK_BATTERING_RAM:{  rolled = battering_ram || circle_attack ? rolled+ modifier: rolled; break;}
            case CIRCLE_ATTACK_LADDER:{         rolled = ladder || circle_attack ? rolled+ modifier: rolled; break;}
            case CIRCLE_ATTACK_SIEGETOWER:{     rolled = siege_tower || circle_attack ? rolled+ modifier: rolled; break;}
            case BOILING_ATTACK_BATTERING_RAM:{ rolled = battering_ram || circle_attack ? rolled+ modifier +1: rolled+1; break;}
            case BOILING_ATTACK_LADDER:{        rolled = ladder || circle_attack ? rolled+ modifier+1: rolled+1; break;}
            case BOILING_ATTACK_SIEGETOWER:{    rolled = siege_tower || circle_attack ? rolled+ modifier+1: rolled+1; break;}
            case CLOSE_COMBAT:{                 rolled = close_combat ? rolled+ modifier+1: rolled; break;}
            case SUPPLY_RAID_ROLL:{             rolled = raid ? rolled+ modifier: rolled; break;}
            case SABOTAGE_ROLL:{                rolled = sabotage ? rolled+ modifier: rolled; break;}
            case COUPURE_ROLL:{                 rolled = coupure ? rolled+ modifier: rolled; break;}
            case RALLY_TROOPS:{                 rolled = rally ? rolled+ modifier: rolled; break;}
        }

        rolled = rolled > 6 ? 6 : rolled;
        rolled = rolled < 1 ? 1 : rolled;
        lastRoll = rolled;
        return rolled;
    }

    public int getLastRoll(){ return lastRoll;}


    private int roll(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }


}
