package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.COVER_OF_DARKNESS;

public class CoverOfDarknessEvent extends EventModel{

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
        if(data.EnemyTracker.CountCloseCombatEnemies() > 0) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
