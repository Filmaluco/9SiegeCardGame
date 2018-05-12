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

    public boolean hasInitialConfig(){  /* so far is the only one required */ return gameData.Player.hasName(); }
    public void setInitialConfig(String player_name){ gameData.Player.setName(player_name);}

    public String getPlayerName(){ return gameData.Player.getName();}

    @Override
    public String toString() {
        return gameData.toString();
    }

    //States

    public void GameSetup(){setState(getState().GameSetup());}
}
