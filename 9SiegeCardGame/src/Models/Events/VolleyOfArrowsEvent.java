package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.VOLLEY_OF_ARROWS;

public class VolleyOfArrowsEvent extends EventModel {

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
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
