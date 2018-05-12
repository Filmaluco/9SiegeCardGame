package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class TrebuchetAttackEvent extends EventModel implements rules, rolls {

    public TrebuchetAttackEvent() {
        //TODO: Special event Implement
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        return null;
    }
}
