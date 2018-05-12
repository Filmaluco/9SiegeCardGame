package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class GateFortifiedEvent extends EventModel implements rules, rolls {

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
        data.EnemyTracker.batteringRam.advance();


        return new DiceModel(eventID);
    }
}
