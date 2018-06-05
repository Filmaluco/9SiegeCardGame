package UI.Text;

import Controllers.GameController;
import SiegeCard.Util.Rolls;
import UI.Text.Util.Read;
import UI.Text.Util.Roll;

import static SiegeCard.Util.Rolls.BOOST_RALLY_TROOPS;
import static SiegeCard.Util.Rolls.RALLY_TROOPS;

public class RallyTroopsMenu {

    private Read read;
    private Roll roll;
    int option;

    public RallyTroopsMenu() {
        read = new Read();
    }

    public void menu(GameController game){
        roll = new Roll(game);
        Rolls target=RALLY_TROOPS;
        System.out.println("Preparing to be motivational!");
        if(game.getMorale()>0) {
            System.out.println("Do you want to trade one supply to get a +1 DRM?\n1-Yes\n0-No");
            option = read.option();
            if (option == 1) {
                target=BOOST_RALLY_TROOPS;
                game.ApplyRules(target);
            } else {
                game.ApplyRules(target);
            }
        }else{
            game.ApplyRules(target);
        }
        roll.yourRoll(target);
    }
}
