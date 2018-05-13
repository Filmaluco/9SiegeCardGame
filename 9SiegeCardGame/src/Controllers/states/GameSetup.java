package Controllers.states;

import Models.GameDataModel;

public class GameSetup extends StateAdapter {

    public GameSetup(GameDataModel g) { super(g); }

    @Override
    public IState GameStart()  {
        return new CardPhase(getGame());
    }
}
