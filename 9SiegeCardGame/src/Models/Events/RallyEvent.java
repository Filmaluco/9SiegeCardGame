package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class RallyEvent extends EventModel implements rules, rolls {

    public RallyEvent() {
        eventID             = RALLY;
        eventName           = "Rally!";
        eventDescription    = "+1 to attacks on Close Combat or Circle Spaces";
        eventActionPoints   = 3;

        siegeTowerMovement  = true;
        batteringRamMovement= true;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.siegeTower.advance();
        data.EnemyTracker.batteringRam.advance();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
