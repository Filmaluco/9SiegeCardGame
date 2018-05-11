package Controllers.states;

import Models.GameDataModel;

public class StateAdapter implements IState {

    private GameDataModel game;

    public StateAdapter(GameDataModel g) { this.game = g; }
    public GameDataModel getGame() { return game; }


    @Override
    public IState GameSetup() { return this; }

    @Override
    public IState lineCheck() {
        return null;
    }

    @Override
    public IState updateBoard() {
        return null;
    }

    @Override
    public IState archersAttack() {
        return null;
    }

    @Override
    public IState boilingAttack() {
        return null;
    }

    @Override
    public IState Coupure() {
        return null;
    }

    @Override
    public IState RallyTroops() {
        return null;
    }

    @Override
    public IState TunnelMovement() {
        return null;
    }

    @Override
    public IState SupplyRaid() {
        return null;
    }

    @Override
    public IState Sabotage() {
        return null;
    }

    @Override
    public IState getState() {
        return null;
    }
}
