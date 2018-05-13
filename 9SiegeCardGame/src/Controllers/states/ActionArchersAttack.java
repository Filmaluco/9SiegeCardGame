package Controllers.states;

import Models.GameDataModel;

public class ActionArchersAttack extends StateAdapter {
    public ActionArchersAttack(GameDataModel g) {
        super(g);
    }

    @Override
    public IState ApplyRules(int TARGET){
        return getGame().Attack(TARGET) ? new ActionPhase(getGame()) : this;
    }
}
