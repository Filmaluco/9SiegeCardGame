package UI.Text;

import Controllers.GameController;
import UI.Text.Util.Roll;

import static SiegeCard.Util.Rolls.COUPURE_ROLL;

public class CoupureMenu {
    private Roll roll;

    public void menu(GameController game){
        roll = new Roll(game);
        if(game.canCoupure()) {
            System.out.println("Preparing to repair damage to the wall");
            game.Coupure();
            roll.yourRoll(COUPURE_ROLL);
        }
    }
}
