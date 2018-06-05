package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.FAITH;

public class FaithEvent extends EventModel{

    public FaithEvent() {
        eventID             = FAITH;
        eventName           = "Faith";
        eventDescription    = "+1 to attacks on the Battering Ram, Ladders, and Morale actions";
        eventActionPoints   = 3;

        ladderMovement      = true;
        siegeTowerMovement  = true;
        batteringRamMovement= true;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.setActionPoints(eventActionPoints);

        data.EnemyTracker.ladder.advance();
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.siegeTower.advance();
        if(data.EnemyTracker.siegeTower.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.batteringRam.advance();
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        return new DiceModel(eventID);
    }
}
