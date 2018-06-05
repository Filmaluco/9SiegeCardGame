package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.Rolls;
import SiegeCard.Util.Rules;

import static SiegeCard.Util.Rules.GUARDS_DISTRACTED;

public class GuardsDistractedEvent extends EventModel{


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
        if(data.EnemyTracker.CountCloseCombatEnemies() > 0) data.Player.tracker.reduceMorale();
        data.Player.setActionPoints(eventActionPoints);

        return new DiceModel(eventID);
    }
}
