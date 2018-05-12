package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class DeathOfALeaderEvent extends EventModel implements rules, rolls {

    public DeathOfALeaderEvent() {
        eventID             = DEATH_OF_A_LEADER;
        eventName           = "Death of a Leader";
        eventDescription    = "Reduce Morale by 1";
        eventActionPoints   = 2;

        ladderMovement      = true;
        siegeTowerMovement  = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.tracker.reduceMorale();

        data.EnemyTracker.ladder.advance();
        data.EnemyTracker.siegeTower.advance();

        return new DiceModel(eventID);
    }
}
