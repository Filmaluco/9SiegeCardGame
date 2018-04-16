package Controllers;

import Controllers.states.IState;
import Controllers.states.SampleState;
import Models.GameDataModel;

public class GameController {

    GameDataModel gameData;
    private IState state;

    public GameController()
    {
        gameData = new GameDataModel();
        setState(new SampleState(gameData));
    }

    private void setState(IState state)
    {
        this.state = state;
    }


}
