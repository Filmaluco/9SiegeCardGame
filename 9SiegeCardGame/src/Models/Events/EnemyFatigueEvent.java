package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class EnemyFatigueEvent extends EventModel implements rules, rolls {

    public EnemyFatigueEvent() {
        eventID             = ENEMY_FATIGUE;
        eventName           = "Enemy Fatigue";
        eventDescription    = "+1 to Coupure, Raid and Sabotage actions";
        eventActionPoints   = 3;

        ladderMovement      = true;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.EnemyTracker.ladder.advance();
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
