package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class CollapsedEvent extends EventModel implements rules, rolls {
    public CollapsedEvent() {
        eventID             = COLLAPSED;
        eventName           = "Collapsed!";
        eventDescription    = "Siege Tower removed from game if on startign space";
        eventActionPoints   = 2;

        ladderMovement = true;
        batteringRamMovement = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.setActionPoints(eventActionPoints);
        data.EnemyTracker.ladder.advance();
        data.EnemyTracker.batteringRam.advance();

        if(data.EnemyTracker.siegeTower.onStartingSpace()) data.EnemyTracker.siegeTower.remove();

        return new DiceModel(eventID);
    }
}
