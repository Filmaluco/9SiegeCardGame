package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rules.BAD_WEATHER;

public class BadWeatherEvent extends EventModel{

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

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
