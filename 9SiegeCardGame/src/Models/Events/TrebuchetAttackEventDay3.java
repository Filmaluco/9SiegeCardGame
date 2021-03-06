package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;

import static SiegeCard.Util.Rolls.RANDOM;
import static SiegeCard.Util.Rules.TREBUCHET_ATTACK;

public class TrebuchetAttackEventDay3 extends EventModel{

    public TrebuchetAttackEventDay3() {eventID             = TREBUCHET_ATTACK;
        eventName           = "Trebuchet Attack";
        eventDescription    = "3 Trebuchets - 2 Damage to wall \n" +
                "2 Trebuchets - 1 Damage to wall \n" +
                "1 Trebuchets - 1 Damage to wall (roll > 3) \n" ;
        eventActionPoints   = 1;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        DiceModel dice = new DiceModel(eventID);

        switch (data.EnemyTracker.getTrebuchets()){
            case 3: { data.Player.tracker.reduceWallStrength();
                data.Player.tracker.reduceWallStrength(); break;}

            case 2: { data.Player.tracker.reduceWallStrength(); break;}

            case 1: { if(dice.roll(RANDOM) > 3) data.Player.tracker.reduceWallStrength(); break; }
        }

        data.Player.setActionPoints(eventActionPoints);

        return dice;
    }
}