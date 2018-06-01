package UI.Text;

import Controllers.GameController;
import UI.Text.Util.Roll;

import static SiegeCard.Util.Rolls.CLOSE_COMBAT;

public class CloseCombatMenu {
    private Roll roll;

    public void menu(GameController game){
        roll = new Roll(game);
        if(game.canCloseCombat()) {
            System.out.println("Entering close combat!!");
            game.CloseCombat();
            roll.yourRoll(CLOSE_COMBAT);
        }
    }
}
