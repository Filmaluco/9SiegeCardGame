package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class GuardsDistractedEvent extends EventModel implements rules, rolls {


    public GuardsDistractedEvent() {
        eventID             = GUARDS_DISTRACTED;
        eventName           = "Guards Distracted";
        eventDescription    = "+1 to sabotage action \n" +
                              "+1 to morale action";
        eventActionPoints   = 2;

        slowestUnitMovement = true;
    }

    public DiceModel applyEvent(GameDataModel data){
        data.EnemyTracker.moveSlowest();
        if(data.EnemyTracker.getCloseCombatEnemies() > 0) data.Player.tracker.reduceMorale();
        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
