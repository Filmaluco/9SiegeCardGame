package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.Rolls;

public class ActionArchersAttack extends StateAdapter {
    public ActionArchersAttack(GameDataModel g) {
        super(g);
    }

    @Override
    public IState ApplyRules(Rolls TARGET){
        return getGame().Attack(TARGET) ? new ActionPhase(getGame()) : this;
    }
}
