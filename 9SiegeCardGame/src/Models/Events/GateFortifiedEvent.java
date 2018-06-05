package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.GATE_FORTIFIED;

public class GateFortifiedEvent extends EventModel{

    public GateFortifiedEvent() {
        eventID             = GATE_FORTIFIED;
        eventName           = "Gata Fortified";
        eventDescription    = "+1 to attack on the Battering Ram";
        eventActionPoints   = 2;

        ladderMovement      = true;
        batteringRamMovement= true;

    }


    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.ladder.advance();
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.batteringRam.advance();
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
