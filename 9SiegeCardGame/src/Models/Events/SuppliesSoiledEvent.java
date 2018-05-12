package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class SuppliesSoiledEvent extends EventModel implements rules, rolls {

    public SuppliesSoiledEvent(){
        
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {
        return null;
    }
}
