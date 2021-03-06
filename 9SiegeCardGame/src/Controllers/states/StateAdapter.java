package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.Constants;
import SiegeCard.Util.Rolls;

import java.io.Serializable;

public class StateAdapter implements IState, Serializable {

    private GameDataModel game;

    public StateAdapter(GameDataModel g) { this.game = g; }
    public GameDataModel getGame() { return game; }


    @Override
    public IState Menu() { return this; }

    @Override
    public IState GameStart()  {
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
    public IState GameOver()  { return this; }

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
    public IState ActionTunnelMovement()  {
        return this;
    }

    @Override
    public IState ActionSupplyRaid()  {
        return this;
    }

    @Override
    public IState ActionCloseCombat()   {
        return this;
    }

    @Override
    public IState ActionCoupure()   { return this; }

    @Override
    public IState ActionSabotage()   { return this; }

    @Override
    public IState GetAdicionalPoints()   { return this; }

    @Override
    public IState moveIntoTunnel() { return this; }

    @Override
    public IState moveInTunnel(Constants TARGET) { return this; }

    @Override
    public IState ApplyRules(Rolls TARGET)  {
        return this;
    }

    @Override
    public IState ApplyRules(Constants TARGET) { return this; }

    @Override
    public IState getState() {
        return this;
    }
}
