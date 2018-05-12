package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class FaithEvent extends EventModel implements rules, rolls {

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
        data.EnemyTracker.siegeTower.advance();
        data.EnemyTracker.batteringRam.advance();

        return new DiceModel(eventID);
    }
}
