package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class RepairedTrebuchetEvent extends EventModel implements rules, rolls {

    public RepairedTrebuchetEvent() {
        eventID             = REPAIRED_TREBUCHET;
        eventName           = "Repaired Trebuchet";
        eventDescription    = "Add 1 Trebuchet (max 3) \n" +
                              "+1 to Coupure Action";
        eventActionPoints   = 2;

        ladderMovement = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        data.EnemyTracker.ladder.advance();
        data.EnemyTracker.addTrebuchet();
        data.Player.setActionPoints(eventActionPoints);
        return new DiceModel(eventActionPoints);

    }
}
