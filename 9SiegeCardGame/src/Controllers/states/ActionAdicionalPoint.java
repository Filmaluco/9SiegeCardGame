package Controllers.states;

import Models.GameDataModel;
import SiegeCard.Util.Constants;

import static SiegeCard.Util.Constants.*;

public class ActionAdicionalPoint extends StateAdapter{
    public ActionAdicionalPoint(GameDataModel g) {
        super(g);
    }

    @Override
    public IState ApplyRules(Constants TARGET){

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
