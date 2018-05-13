package Controllers;

import Controllers.states.GameSetup;
import Controllers.states.IState;
import Models.GameDataModel;

public class GameController {

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

    public boolean canArchersAttack() { return gameData.canArchersAttack(); }
    public boolean canBoilAttack()  { return  gameData.canBoilAttack(); }
    public boolean canCloseCombat() { return gameData.canCloseCombat(); }
    public boolean canCoupure() { return gameData.canCoupure(); }
    public boolean canRallyTroops() { return gameData.canRallyTroops(); }
    public boolean canUseTunnelMovemnt() { return gameData.canUseTunnelMovemnt(); }
    public boolean canSupplyRaid() { return gameData.canSupplyRaid(); }
    public boolean canSabotage() { return gameData.canSabotage(); }

    public boolean batteringRamOnStartingSpace(){ return gameData.EnemyTracker.batteringRam.onStartingSpace();}
    public boolean ladderOnStartingSpace(){ return gameData.EnemyTracker.ladder.onStartingSpace();}
    public boolean siegeTowerOnStartingSpace(){ return gameData.EnemyTracker.siegeTower.onStartingSpace();}

    public int batteringRamStrength(){ return gameData.EnemyTracker.batteringRam.getStrength();}
    public int ladderStrength(){ return gameData.EnemyTracker.ladder.getStrength();}
    public int siegeTowerStrength(){ return gameData.EnemyTracker.siegeTower.getStrength();}

    public int getLastRoll(){ return gameData.Dice.getLastRoll(); }
    @Override
    public String toString() {
        return gameData.toString();
    }

    //States
    public void Start(){setState(getState().GameStart());}
    public void Exit(){setState(getState().GameExit());}
    public void Menu(){setState(getState().Menu());}

    public void ArchersAttack(){setState(getState().TrackSelectionArchersAttack());}
    public void ApplyRules(int target){setState(getState().ApplyRules(target));}

    public void StartTurn(){setState(getState().StartTurn());}
    public void EndTurn(){setState(getState().EndTurn());}


}
