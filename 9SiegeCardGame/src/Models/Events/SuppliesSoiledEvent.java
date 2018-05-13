package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class SuppliesSoiledEvent extends EventModel implements rules, rolls {

    public SuppliesSoiledEvent(){
        eventID             = SUPPLIES_SPOILED;
        eventName           = "Supplies Spoiled";
        eventDescription    = "Reduce Supplies by 1";
        eventActionPoints   = 2;

        ladderMovement      = true;
        
    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        data.Player.tracker.reduceSupplies();

        data.EnemyTracker.ladder.advance();
        if(data.EnemyTracker.ladder.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
