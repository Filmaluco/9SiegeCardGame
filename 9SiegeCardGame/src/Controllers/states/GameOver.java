package Controllers.states;

import Models.GameDataModel;

public class GameOver extends StateAdapter {

    public GameOver(GameDataModel g) {
        super(g);
    }

    @Override
    public IState Menu() { return new GameSetup(getGame()); }

    @Override
    public IState GameExit() { return new GameExit(getGame()); }
}
