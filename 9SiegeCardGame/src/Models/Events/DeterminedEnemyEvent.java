package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class DeterminedEnemyEvent extends EventModel implements rules, rolls {

    public DeterminedEnemyEvent() {
        eventID             = DETERMINED_ENEMY;
        eventName           = "Determined Enemy";
        eventDescription    = "-1 to attacks on the Battering Ram";
        eventActionPoints   = 2;

        batteringRamMovement  = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.setActionPoints(eventActionPoints);

        data.EnemyTracker.batteringRam.advance();

        return new DiceModel(eventID);
    }
}
