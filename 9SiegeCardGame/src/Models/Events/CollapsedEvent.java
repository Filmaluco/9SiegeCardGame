package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class CollapsedEvent extends EventModel implements rules, rolls {
    public CollapsedEvent() {
        //TODO: Special Implement
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        return null;
    }
}
