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

    @Override
    public String toString() {
        return gameData.toString();
    }

    //States
    public void Start(){setState(getState().GameStart());}

    public void StartTurn(){setState(getState().StartTurn());}
    public void EndTurn(){setState(getState().EndTurn());}

    public void GameWon(){setState(getState().GameWon());}
    public void GameOver(){setState(getState().GameOver());}
    public void GameSave(){setState(getState().GameSave());}
    public void GameExit(){setState(getState().GameExit());}

    public void ActionSupplyArchersAttack(){setState(getState().TrackSelectionArchersAttack());}
    public void ActionBoilingAttack(){setState(getState().TrackSelectionBoilingAttack());}
    public void ActionRallyTroops(){setState(getState().ActionRallyTroops());}
    public void ActionTunnelMovement(){setState(getState().ActionTunnelMovement());}
    public void ActionSupplyRaid(){getState().ActionSupplyRaid();}

    public void ActionCloseCombat(){setState(getState().ActionCloseCombat());}
    public void ActionCoupure(){setState(getState().ActionCoupure());}
    public void ActionSabotage(){setState(getState().ActionSabotage());}
    public void GetAdicionalPoints(){setState(getState().GetAdicionalPoints());}

    public void ApplyRules(){setState(getState().ApplyRules());}

}
