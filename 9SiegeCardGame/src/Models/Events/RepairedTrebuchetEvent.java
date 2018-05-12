package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class RepairedTrebuchetEvent extends EventModel implements rules, rolls {

    public RepairedTrebuchetEvent() {
        //TODO: Implement Special 
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        return null;
    }
}
