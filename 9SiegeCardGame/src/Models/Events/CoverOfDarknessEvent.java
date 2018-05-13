package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class CoverOfDarknessEvent extends EventModel implements rules, rolls {

    public CoverOfDarknessEvent() {
        eventID             = COVER_OF_DARKNESS;
        eventName           = "Cover of darkness";
        eventDescription    = "+1 to Raid and Sabotage actions";
        eventActionPoints   = 3;

        slowestUnitMovement = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.moveSlowest();
        if(data.EnemyTracker.getCloseCombatEnemies() > 0) data.Player.tracker.reduceMorale();

        return new DiceModel(eventID);
    }
}
