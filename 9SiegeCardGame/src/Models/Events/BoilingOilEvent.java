package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class BoilingOilEvent extends EventModel implements rules, rolls {

    public BoilingOilEvent() {
        eventID             = BOILING_OIL;
        eventName           = "Boilling Oil";
        eventDescription    = "+2 to attacks on enemy units in circle spaces";
        eventActionPoints   = 2;

        ladderMovement      = true;
        batteringRamMovement  = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.ladder.advance();
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.batteringRam.advance();
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
