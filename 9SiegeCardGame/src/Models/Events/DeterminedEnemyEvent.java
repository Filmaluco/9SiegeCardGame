package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.DETERMINED_ENEMY;

public class DeterminedEnemyEvent extends EventModel{

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
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        return new DiceModel(eventID);
    }
}
