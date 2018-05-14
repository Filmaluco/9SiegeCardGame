package Models;

import SiegeCard.Util.*;

import java.io.Serializable;

public class GameDataModel implements constants, rolls , Serializable{

    //is it worth having protected? because I want to acess their functions
    public EnemyTrackerModel EnemyTracker;
    public PlayerModel Player;
    public DiceModel Dice;
    public DeckModel Deck;

    private int currentDay,
                currentTurn;

    private boolean canArchersAttack,
                    canBoilAttack,
                    canCloseCombat,
                    canCoupure,
                    canRallyTroops,
                    canUseTunnelMovemnt,
                    canSupplyRaid,
                    canSabotage,
                    canGetAdicionalPoint;

    public GameDataModel() {
        Player = new PlayerModel();
        EnemyTracker = new EnemyTrackerModel();
        Deck = new DeckModel();
        currentDay = 1;
        currentTurn = 1;
        canArchersAttack = true;
        canBoilAttack = true;
        canCloseCombat = true;
        canCoupure = true;
        canRallyTroops = true;
        canUseTunnelMovemnt = true;
        canSupplyRaid = true;
        canSabotage = true;
        canGetAdicionalPoint = true;
    }


    public int getCurrentDay() { return currentDay; }
    public int getCurrentTurn() { return currentTurn; }

    public boolean hasToChangeDay(){return currentTurn > 7;}
    public void nextDay(){if(hasToChangeDay()){currentTurn = 1; currentDay++;}}
    public int nextTurn(){return ++currentTurn;}

    public void useBoilingAttack(){canBoilAttack = false;}
    public void resetBoilingAttack(){canBoilAttack = true;}

    public void useGetAdicionalPoint(){ canGetAdicionalPoint = false;}
    public void resetGetAdicionalPoint(){ canGetAdicionalPoint = true;}

    public boolean hasBoiledAttacked(){return !canBoilAttack;}
    public boolean canBoilAttack(){ canBoilAttack = EnemyTracker.batteringRam.onCircleSpace() ||
            EnemyTracker.ladder.onCircleSpace() ||
            EnemyTracker.siegeTower.onCircleSpace() &&
            Player.getActionPoints() > 0 && canBoilAttack;

    return canBoilAttack;}


    public  boolean needsToCloseCombat(){
        if(EnemyTracker.getCloseCombatEnemies() > 1) {
            return true;
        }
        return false;
    }
    public boolean hasUsedAdicionalPoint(){return !canGetAdicionalPoint;}
    public boolean canGetAdicionalPoint(){ canGetAdicionalPoint = canGetAdicionalPoint &&
                                            Player.tracker.getSupplies() > 0 &&
                                            Player.tracker.getMorale() > 0;
                                            return canGetAdicionalPoint;}

    public void resetAllActions(){
        canArchersAttack = true;
        canBoilAttack = true;
        canCloseCombat = true;
        canCoupure = true;
        canRallyTroops = true;
        canUseTunnelMovemnt = true;
        canSupplyRaid = true;
        canSabotage = true;
        canGetAdicionalPoint = true;
    }

    public void lockAllActions(){
        canArchersAttack = false;
        canBoilAttack = false;
        canCloseCombat = false;
        canCoupure = false;
        canRallyTroops = false;
        canUseTunnelMovemnt = false;
        canSupplyRaid = false;
        canSabotage = false;
        canGetAdicionalPoint = false;
    }

    public void lockArchersAttack(){ canArchersAttack = false;}
    public void lockBoilAttack(){ canBoilAttack = false;}
    public void lockAdicionalPoint(){ canGetAdicionalPoint = false;}
    public void lockCloseCombat(){ canCloseCombat = false;}
    public void lockCoupure(){ canCoupure = false;}
    public void lockRallyTroops(){ canRallyTroops = false;}
    public void lockUseTunnelMovemnt(){ canUseTunnelMovemnt = false;}
    public void lockSupplyRaid(){ canSupplyRaid = false;}
    public void lockSabotage(){ canSabotage = false;}

    public void unLockAdicionalPoint(){ canGetAdicionalPoint = true;}
    public void unLockArchersAttack(){ canArchersAttack = true;}
    public void unLockBoilAttack(){ canBoilAttack = true;}
    public void unLockCloseCombat(){ canCloseCombat = true;}
    public void unLockCoupure(){ canCoupure = true;}
    public void unLockRallyTroops(){ canRallyTroops = true;}
    public void unLockUseTunnelMovemnt(){ canUseTunnelMovemnt = true;}
    public void unLockSupplyRaid(){ canSupplyRaid = true;}
    public void unLockSabotage(){ canSabotage = true;}

    public boolean canArchersAttack(){  canArchersAttack = !EnemyTracker.batteringRam.onStartingSpace() ||
                                        !EnemyTracker.ladder.onStartingSpace() ||
                                        !EnemyTracker.siegeTower.onStartingSpace() &&
                                        Player.getActionPoints() > 0 && canArchersAttack;
                                        return canArchersAttack;}

    public boolean canCloseCombat(){    canCloseCombat = EnemyTracker.batteringRam.onCloseCombat() ||
                                        EnemyTracker.ladder.onCloseCombat() ||
                                        EnemyTracker.siegeTower.onCloseCombat() &&
                                        Player.getActionPoints() > 0 &&
                                        canCloseCombat;
                                        return canCloseCombat;
    }
    public boolean canCoupure(){    canCoupure = canCoupure &&
                                    Player.tracker.getWallStrength() < 4 &&
                                    Player.getActionPoints() > 0;
                                    return canCoupure;}

    public boolean canRallyTroops(){ canRallyTroops = canRallyTroops && Player.tracker.getMorale() < 4;
                                     return canRallyTroops;}
    public boolean canUseTunnelMovemnt(){ return canUseTunnelMovemnt;}  //TODO: better validation
    public boolean canSupplyRaid(){ return canSupplyRaid;}              //TODO: better validation
    public boolean canSabotage(){ return canSabotage;}                  //TODO: better validation

    public boolean isGameWon(){ return currentDay == 3 && currentTurn > 7; }
    public boolean isGameOver(){
        if(EnemyTracker.getCloseCombatEnemies() >= 3){ return true; }
        if(Player.tracker.getLostAttributes() >= 2){return true;}
        return false;
    }
    public boolean lostTurn(){
        if(EnemyTracker.getCloseCombatEnemies() >= 2){ return true; }
        if(Player.tracker.getLostAttributes() > 0){return true;}
        return false;
    }

    public boolean Attack(int TARGET){
        if(!(canArchersAttack() || canCloseCombat() || canBoilAttack() || Player.getActionPoints() == 0)){ return false;}
        switch (TARGET){
            case BATTERING_RAM:{
                if(EnemyTracker.batteringRam.onCircleSpace() && !EnemyTracker.batteringRam.onStartingSpace()){ //Target is on Circle
                    if(Dice.roll(CIRCLE_ATTACK_BATTERING_RAM) > EnemyTracker.batteringRam.getStrength()) {
                        EnemyTracker.batteringRam.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(EnemyTracker.batteringRam.onCloseCombat()&& !EnemyTracker.batteringRam.onStartingSpace()){ //Target is on Close Combat
                    if(Dice.roll(CLOSE_COMBAT) > EnemyTracker.batteringRam.getStrength()) {
                        EnemyTracker.batteringRam.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(!EnemyTracker.batteringRam.onCircleSpace() && !EnemyTracker.batteringRam.onCloseCombat() && !EnemyTracker.batteringRam.onStartingSpace()){ //Target is not on close combat or Circle
                    if(Dice.roll(NORMAL_ATTACK_BATTERING_RAM) > EnemyTracker.batteringRam.getStrength()) {
                        EnemyTracker.batteringRam.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
            case LADDER:{
                if(EnemyTracker.ladder.onCircleSpace()&& !EnemyTracker.ladder.onStartingSpace()){ //Target is on Circle
                    if(Dice.roll(CIRCLE_ATTACK_LADDER) > EnemyTracker.ladder.getStrength()) {
                        EnemyTracker.ladder.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(EnemyTracker.ladder.onCloseCombat()&& !EnemyTracker.ladder.onStartingSpace()){ //Target is on Close Combat
                    if(Dice.roll(CLOSE_COMBAT) > EnemyTracker.ladder.getStrength()) {
                        EnemyTracker.ladder.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(!EnemyTracker.ladder.onCircleSpace() && !EnemyTracker.ladder.onCloseCombat()&& !EnemyTracker.ladder.onStartingSpace()){ //Target is not on close combat or Circle
                    if(Dice.roll(NORMAL_ATTACK_LADDER) > EnemyTracker.ladder.getStrength()) {
                        EnemyTracker.ladder.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
            case SIEGE_TOWER:{
                if(EnemyTracker.siegeTower.onCircleSpace() && !EnemyTracker.siegeTower.onStartingSpace()){ //Target is on Circle
                    if(Dice.roll(CIRCLE_ATTACK_SIEGETOWER) > EnemyTracker.siegeTower.getStrength()) {
                        EnemyTracker.siegeTower.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(EnemyTracker.siegeTower.onCloseCombat() && !EnemyTracker.siegeTower.onStartingSpace()){ //Target is on Close Combat
                    if(Dice.roll(CLOSE_COMBAT) > EnemyTracker.siegeTower.getStrength()){
                        EnemyTracker.siegeTower.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
                if(!EnemyTracker.siegeTower.onCircleSpace() && !EnemyTracker.siegeTower.onCloseCombat() && !EnemyTracker.siegeTower.onStartingSpace()){ //Target is not on close combat or Circle
                    if(Dice.roll(NORMAL_ATTACK_SIEGETOWER) > EnemyTracker.siegeTower.getStrength()) {
                        EnemyTracker.siegeTower.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
        }
        Player.removeActionPoint();
        return true;
    }

    public boolean BoilAttack(int TARGET){
        if(!canArchersAttack() || !canCloseCombat() || !canBoilAttack() || Player.getActionPoints() == 0){ return false;}
        lockBoilAttack();

        switch (TARGET){
            case BATTERING_RAM:{
                if(EnemyTracker.batteringRam.onCircleSpace()){ //Target is on Circle
                    if(Dice.roll(BOILING_ATTACK_BATTERING_RAM) > EnemyTracker.batteringRam.getStrength()) {
                        EnemyTracker.batteringRam.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
            case LADDER:{
                if(EnemyTracker.ladder.onCircleSpace()){ //Target is on Circle
                    if(Dice.roll(BOILING_ATTACK_LADDER) > EnemyTracker.ladder.getStrength()) {
                        EnemyTracker.ladder.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
            case SIEGE_TOWER:{
                if(EnemyTracker.siegeTower.onCircleSpace()){ //Target is on Circle
                    if(Dice.roll(BOILING_ATTACK_SIEGETOWER) > EnemyTracker.siegeTower.getStrength()) {
                        EnemyTracker.siegeTower.retreat();
                        Player.removeActionPoint();
                        return true;
                    }
                }
            } break;
        }
        if(Dice.getLastRoll()==1){
            Player.tracker.reduceMorale();
        }
        Player.removeActionPoint();
        return true;

    }

    public boolean CloseAttack(){
        Player.removeActionPoint();
        if(EnemyTracker.batteringRam.onCloseCombat()) { //Target is on Close Combat
            if (Dice.roll(CLOSE_COMBAT) > EnemyTracker.batteringRam.getStrength())
                EnemyTracker.batteringRam.retreat();
        }else if(EnemyTracker.ladder.onCloseCombat()) { //Target is on Close Combat
            if (Dice.roll(CLOSE_COMBAT) > EnemyTracker.ladder.getStrength())
                EnemyTracker.ladder.retreat();
        }else{
            if (Dice.roll(CLOSE_COMBAT) > EnemyTracker.siegeTower.getStrength())
                EnemyTracker.siegeTower.retreat();
        }

        if(Dice.getLastRoll() == 1) Player.tracker.reduceMorale();

        return true;
    }


    @Override
    public String toString() {
        String s="";
        s+=EnemyTracker.toString()+"\n";
        s+=Player.toString()+"\n";
        s+="Day: [" + getCurrentDay() + "]" + " Turn: [" + getCurrentTurn() + "]" + " Action Points: [" + Player.getActionPoints() + "]\n\n";
        s+=Deck.toString();
        return s;
    }
}