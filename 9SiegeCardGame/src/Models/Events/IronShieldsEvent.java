package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class IronShieldsEvent extends EventModel implements rules, rolls {

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

        return new DiceModel(eventID);
    }
}
