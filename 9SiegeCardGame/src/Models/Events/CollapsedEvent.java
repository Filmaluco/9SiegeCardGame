package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.COLLAPSED;

public class CollapsedEvent extends EventModel{
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
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();
        data.EnemyTracker.batteringRam.advance();
        if(data.EnemyTracker.batteringRam.onCloseCombat()) data.Player.tracker.reduceMorale();

        if(data.EnemyTracker.siegeTower.onStartingSpace()) data.EnemyTracker.siegeTower.remove();

        return new DiceModel(eventID);
    }
}
