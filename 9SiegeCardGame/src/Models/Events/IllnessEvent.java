package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.*;

public class IllnessEvent extends EventModel implements rules, rolls {

    public IllnessEvent(){
        eventID             = ILLNESS;
        eventName           = "IllnessEvent";
        eventDescription    = "Reduce Morale by 1 \n" +
                              "Reduce Supplies by 1";
        eventActionPoints   = 2;

        siegeTowerMovement = true;
    }

    public DiceModel applyEvent(GameDataModel data){
        data.Player.tracker.reduceMorale();
        data.Player.tracker.reduceSupplies();


        data.EnemyTracker.siegeTower.advance();
        if(data.EnemyTracker.siegeTower.onCloseCombat()) data.Player.tracker.reduceMorale();

        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }

}
