package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class BadWeatherEvent extends EventModel implements rules, rolls {

    public BadWeatherEvent() {
        eventID             = BAD_WEATHER;
        eventName           = "Bad Weather";
        eventDescription    = "Only Raid and Sabotage allowed this turn";
        eventActionPoints   = 2;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.lockAllActions();
        data.unLockSabotage();
        data.unLockSupplyRaid();

        return new DiceModel(eventID);
    }
}
