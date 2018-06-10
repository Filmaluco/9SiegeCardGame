package Controllers;

import Controllers.states.GameSetup;
import Controllers.states.IState;
import Models.GameDataModel;
import SiegeCard.Util.Constants;
import SiegeCard.Util.Rolls;

import java.io.Serializable;

public class GameController implements Serializable{

    private GameDataModel gameData;
    private IState state;

    public GameController()
    {
        gameData = new GameDataModel();
        setState(new GameSetup(gameData));
    }

    public GameDataModel getGameData() { return gameData; }

    private void setState(IState state)
    {
        this.state = state;
    }

    public IState getState() {
        return state;
    }

    public boolean hasInitialConfig(){ return gameData.Player.hasName(); }
    public void setInitialConfig(String player_name){ gameData.Player.setName(player_name);}

    public String getPlayerName(){ return gameData.Player.getName();}

    public int getActionPoints(){ return gameData.Player.getActionPoints(); }
    public int getCurrentTurn(){ return gameData.getCurrentTurn(); }
    public int getCurrentDay(){ return gameData.getCurrentTurn(); }

    public int getMorale(){ return gameData.Player.tracker.getMorale();}
    public int getSupplies(){ return gameData.Player.tracker.getSupplies();}
    public int getWallStrenght(){ return gameData.Player.tracker.getWallStrength();}

    public boolean canArchersAttack() { return gameData.canArchersAttack(); }
    public boolean canBoilAttack()  { return  gameData.canBoilAttack(); }
    public boolean canCloseCombat() { return gameData.canCloseCombat(); }
    public boolean canCoupure() { return gameData.canCoupure(); }
    public boolean canRallyTroops() { return gameData.canRallyTroops(); }
    public boolean canUseTunnelMovemnt() { return gameData.canUseTunnelMovemnt(); }
    public boolean canSupplyRaid() { return gameData.canSupplyRaid(); }
    public boolean canSabotage() { return gameData.canSabotage(); }
    public boolean canGetAdicionalPoint() { return gameData.canGetAdicionalPoint(); }

    public boolean batteringRamOnStartingSpace(){ return gameData.EnemyTracker.batteringRam.onStartingSpace();}
    public boolean ladderOnStartingSpace(){ return gameData.EnemyTracker.ladder.onStartingSpace();}
    public boolean siegeTowerOnStartingSpace(){ return gameData.EnemyTracker.siegeTower.onStartingSpace();}

    public boolean batteringRamOnCircleSpace(){ return gameData.EnemyTracker.batteringRam.onCircleSpace();}
    public boolean ladderOnCircleSpace(){ return gameData.EnemyTracker.ladder.onCircleSpace();}
    public boolean siegeTowerOnCircleSpace(){ return gameData.EnemyTracker.siegeTower.onCircleSpace();}


    public int batteringRamStrength(){ return gameData.EnemyTracker.batteringRam.getStrength();}
    public int ladderStrength(){ return gameData.EnemyTracker.ladder.getStrength();}
    public int siegeTowerStrength(){ return gameData.EnemyTracker.siegeTower.getStrength();}

    public int getLastRoll(){ return gameData.Dice.getLastRoll(); }

    public boolean canMoveInTunnel(){ return gameData.canUseTunnelMovemnt() && gameData.Player.tracker.inTunnel(); }
    public boolean canMoveIntoTunnel(){ return gameData.canUseTunnelMovemnt() && !gameData.Player.tracker.inTunnel(); }

    public boolean canUseFreeMovement(){ return !gameData.hasUsedTunnelMovement(); }

    public boolean canUseFastMovement(){ return gameData.canUseTunnelMovemnt() && gameData.Player.getActionPoints() > 0; }



    @Override
    public String toString() {
        return gameData.toString();
    }

    //States
    public void Start(){setState(getState().GameStart());}
    public void Exit(){setState(getState().GameExit());}
    public void Menu(){setState(getState().Menu());}

    public void ArchersAttack(){setState(getState().TrackSelectionArchersAttack());}
    public void BoilingAttack(){setState(getState().TrackSelectionBoilingAttack());}
    public void CloseCombat(){setState(getState().ActionCloseCombat());}
    public void RallyTroops(){setState(getState().ActionRallyTroops());}
    public void Coupure(){setState(getState().ActionCoupure());}
    public void Adicional(){setState(getState().GetAdicionalPoints());}
    public void Tunel(){setState(getState().ActionTunnelMovement());}
    public void MoveInTunnel(Constants target){setState(getState().moveInTunnel(target));}
    public void MoveIntoTunnel(){setState(getState().moveIntoTunnel());}

    public void ApplyRules(Rolls target){setState(getState().ApplyRules(target));}
    public void ApplyRules(Constants target){setState(getState().ApplyRules(target));}

    public void StartTurn(){setState(getState().StartTurn());}
    public void EndTurn(){setState(getState().EndTurn());}


}
