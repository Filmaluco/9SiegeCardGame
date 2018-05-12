package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class BadWeatherEvent extends EventModel implements rules, rolls {

    public BadWeatherEvent() {
        //TODO: Implement Special
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        return null;
    }
}
