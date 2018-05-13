package Controllers.states;

import Models.GameDataModel;

public class ActionBoilingAttack extends StateAdapter {
    public ActionBoilingAttack(GameDataModel g) { super(g); }

    @Override
    public IState ApplyRules(int TARGET){
        return getGame().Attack(TARGET) ? new ActionPhase(getGame()) : this;
    }
}
