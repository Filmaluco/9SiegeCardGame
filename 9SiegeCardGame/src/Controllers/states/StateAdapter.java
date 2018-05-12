package Controllers.states;

import Models.GameDataModel;

public class StateAdapter implements IState {

    private GameDataModel game;

    public StateAdapter(GameDataModel g) { this.game = g; }
    public GameDataModel getGame() { return game; }


    @Override
    public IState GameSetup()  {
        return this;
    }

    @Override
    public IState StartTurn()  {
        return this;
    }

    @Override
    public IState EndTurn()  {
        return this;
    }

    @Override
    public IState GameWon()  {
        return this;
    }

    @Override
    public IState GameOver()  {
        return this;
    }

    @Override
    public IState GameSave()  {
        return this;
    }

    @Override
    public IState GameExit()  {
        return this;
    }

    @Override
    public IState TrackSelectionArchersAttack()  {
        return this;
    }

    @Override
    public IState TrackSelectionBoilingAttack()  {
        return this;
    }

    @Override
    public IState ActionRallyTroops()  {
        return this;
    }

    @Override
    public IState ActionTrunnelMovement()  {
        return this;
    }

    @Override
    public IState ActionSupplyRaid()  {
        return this;
    }

    @Override
    public IState ApplyRules()  {
        return this;
    }

    @Override
    public IState getState() {
        return this;
    }
}
