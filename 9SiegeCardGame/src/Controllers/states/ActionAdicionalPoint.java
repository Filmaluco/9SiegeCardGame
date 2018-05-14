package Controllers.states;

import Models.GameDataModel;

import static SiegeCard.Util.constants.*;

public class ActionAdicionalPoint extends StateAdapter{
    public ActionAdicionalPoint(GameDataModel g) {
        super(g);
    }

    @Override
    public IState ApplyRules(int TARGET){

        getGame().Player.setActionPoints(getGame().Player.getActionPoints()+1);
        getGame().lockAdicionalPoint();

        switch (TARGET){
            case MORALE:{
                getGame().Player.tracker.reduceMorale();
                break;
            }
            case SUPPLY:{
                getGame().Player.tracker.reduceSupplies();
                break;
            }
        }
        return new ActionPhase(getGame());
    }
}
