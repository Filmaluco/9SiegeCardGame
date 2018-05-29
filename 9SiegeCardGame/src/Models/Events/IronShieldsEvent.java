package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.IRON_SHIELDS;

public class IronShieldsEvent extends EventModel{

    public IronShieldsEvent() {
        eventID             = IRON_SHIELDS;
        eventName           = "Iron Shields";
        eventDescription    = "-1 to attacks on the Siege Tower";
        eventActionPoints   = 2;

        siegeTowerMovement  = true;
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.setActionPoints(eventActionPoints);

        data.EnemyTracker.siegeTower.advance();
        if(data.EnemyTracker.siegeTower.onCloseCombat()) data.Player.tracker.reduceMorale();

        return new DiceModel(eventID);
    }
}
