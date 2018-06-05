package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.REPAIRED_TREBUCHET;

public class RepairedTrebuchetEvent extends EventModel{

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
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.addTrebuchet();
        data.Player.setActionPoints(eventActionPoints);
        return new DiceModel(eventID);

    }
}
