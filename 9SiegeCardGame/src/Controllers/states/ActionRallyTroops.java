package Controllers.states;

import Models.GameDataModel;

import static SiegeCard.Util.rolls.BOOST_RALLY_TROOPS;
import static SiegeCard.Util.rolls.RALLY_TROOPS;

public class ActionRallyTroops extends StateAdapter{
    public ActionRallyTroops(GameDataModel g) { super(g); }

    @Override
    public IState ApplyRules(int TARGET){

        if(getGame().Player.tracker.getSupplies() == 0) TARGET = RALLY_TROOPS;

        if(TARGET == RALLY_TROOPS){
            if(getGame().Dice.roll(RALLY_TROOPS) > 4) getGame().Player.tracker.increaseMorale();
        }else if(TARGET == BOOST_RALLY_TROOPS){
            if(getGame().Dice.roll(RALLY_TROOPS)+1 > 4) getGame().Player.tracker.increaseMorale();
            getGame().Player.tracker.reduceSupplies();
        }

        getGame().Player.removeActionPoint();

        return new ActionPhase(getGame());
    }
}
