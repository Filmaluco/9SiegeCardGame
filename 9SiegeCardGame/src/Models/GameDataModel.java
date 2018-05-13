package Models;

import SiegeCard.Util.constants;

public class GameDataModel implements constants {

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
    public void nextDay(){if(hasToChangeDay()){currentTurn = 0; currentDay++;}}
    public int nextTurn(){return ++currentTurn;}

    public void useBoilingAttack(){canBoilAttack = false;}
    public void resetBoilingAttack(){canBoilAttack = true;}

    public void useGetAdicionalPoint(){ canGetAdicionalPoint = false;}
    public void resetGetAdicionalPoint(){ canGetAdicionalPoint = true;}

    public boolean hasBoiledAttacked(){return !canBoilAttack;}
    public boolean canBoilAttack(){return canBoilAttack;}

    public boolean hasUsedAdicionalPoint(){return !canGetAdicionalPoint;}
    public boolean canGetAdicionalPoint(){return canGetAdicionalPoint;}

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
    public void lockCloseCombat(){ canCloseCombat = false;}
    public void lockCoupure(){ canCoupure = false;}
    public void lockRallyTroops(){ canRallyTroops = false;}
    public void lockUseTunnelMovemnt(){ canUseTunnelMovemnt = false;}
    public void lockSupplyRaid(){ canSupplyRaid = false;}
    public void lockSabotage(){ canSabotage = false;}

    public void unLockArchersAttack(){ canArchersAttack = true;}
    public void unLockBoilAttack(){ canBoilAttack = true;}
    public void unLockCloseCombat(){ canCloseCombat = true;}
    public void unLockCoupure(){ canCoupure = true;}
    public void unLockRallyTroops(){ canRallyTroops = true;}
    public void unLockUseTunnelMovemnt(){ canUseTunnelMovemnt = true;}
    public void unLockSupplyRaid(){ canSupplyRaid = true;}
    public void unLockSabotage(){ canSabotage = true;}

    public boolean canArchersAttack(){ return canArchersAttack;}
    public boolean canCloseCombat(){ return canCloseCombat;}
    public boolean canCoupure(){ return canCoupure;}
    public boolean canRallyTroops(){ return canRallyTroops;}
    public boolean canUseTunnelMovemnt(){ return canUseTunnelMovemnt;}
    public boolean canSupplyRaid(){ return canSupplyRaid;}
    public boolean canSabotage(){ return canSabotage;}

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