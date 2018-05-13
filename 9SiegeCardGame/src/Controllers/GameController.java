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
