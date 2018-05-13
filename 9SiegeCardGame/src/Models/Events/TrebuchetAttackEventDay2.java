package Models.Events;

import Models.DiceModel;
import Models.EventModel;
import Models.GameDataModel;
import SiegeCard.Util.rolls;
import SiegeCard.Util.rules;

public class TrebuchetAttackEventDay2 extends EventModel implements rules, rolls {

    public TrebuchetAttackEventDay2() {eventID             = TREBUCHET_ATTACK;
        eventName           = "Trebuchet Attack";
        eventDescription    = "3 Trebuchets - 2 Damage to wall \n" +
                "2 Trebuchets - 1 Damage to wall \n" +
                "1 Trebuchets - 1 Damage to wall (roll > 3) \n" ;
        eventActionPoints   = 2;

    }

    @Override
    public DiceModel applyEvent(GameDataModel data) {

        DiceModel dice = new DiceModel(eventID);

        switch (data.EnemyTracker.getTrebuchetCount()){
            case 3: { data.Player.tracker.reduceWallStrength();
                data.Player.tracker.reduceWallStrength(); break;}

            case 2: { data.Player.tracker.reduceWallStrength(); break;}

            case 1: { if(dice.roll(RANDOM) > 3) data.Player.tracker.reduceWallStrength(); break; }
        }

        data.Player.setActionPoints(eventActionPoints);

        return dice;
    }
}