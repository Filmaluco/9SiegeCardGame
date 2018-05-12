package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class VolleyOfArrowsEvent extends EventModel implements rules, rolls {

    public VolleyOfArrowsEvent() {
        eventID             = VOLLEY_OF_ARROWS;
        eventName           = "Volley of Arrows";
        eventDescription    = "+1 to all attacks";
        eventActionPoints   = 3;

        batteringRamMovement  = true;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.batteringRam.advance();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
