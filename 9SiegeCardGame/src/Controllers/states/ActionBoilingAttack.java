package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.Rolls;

public class ActionBoilingAttack extends StateAdapter {
    public ActionBoilingAttack(GameDataModel g) { super(g); }

    @Override
    public IState ApplyRules(Rolls TARGET){
        return getGame().BoilAttack(TARGET) ? new ActionPhase(getGame()) : this;
    }
}
