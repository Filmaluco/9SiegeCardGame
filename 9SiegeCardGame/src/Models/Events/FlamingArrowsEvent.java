package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.FLAMING_ARROWS;


public class FlamingArrowsEvent extends EventModel {
    public FlamingArrowsEvent() {
        eventID             = FLAMING_ARROWS;
        eventName           = "Flaming Arrows";
        eventDescription    = "+1 to attacks on the Siege Engine";
        eventActionPoints   = 3;

        siegeTowerMovement  = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.siegeTower.advance();
        if(data.EnemyTracker.siegeTower.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
