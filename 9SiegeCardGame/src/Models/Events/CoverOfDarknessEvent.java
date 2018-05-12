package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class CoverOfDarknessEvent extends EventModel implements rules, rolls {

    public CoverOfDarknessEvent() {
        eventID             = COVER_OF_DARKNESS;
        eventDescription    = "+1 to Raid and Sabotage actions";
        eventName           = "Cover of darkness";
        eventActionPoints   = 3;

        slowestUnitMovement = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        //TODO: Move slowest!

        return new DiceModel(eventID);
    }
}
