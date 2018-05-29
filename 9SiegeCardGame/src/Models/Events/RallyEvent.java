package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.RALLY;

public class RallyEvent extends EventModel{

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
        if(data.EnemyTracker.siegeTower.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.batteringRam.advance();
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
