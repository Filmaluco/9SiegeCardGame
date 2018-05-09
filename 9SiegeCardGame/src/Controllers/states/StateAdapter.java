package Controllers.states;

import Models.GameDataModel;

public class StateAdapter implements IState {

    private GameDataModel game;

    public StateAdapter(GameDataModel g) { this.game = g; }

    public GameDataModel getGame() { return game; }


    @Override
    public IState GameSetup() { return this; }
}
