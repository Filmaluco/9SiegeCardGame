package UI.Text.Util;

import Controllers.GameController;
import SiegeCard.Util.Rolls;

import java.util.Scanner;

public class Roll {

    private GameController game;

    public Roll(GameController game) { this.game = game; }

    public void yourRoll(Rolls target){
        int rollNeeded;
        Scanner enter = new Scanner(System.in);

        switch (target){
            case BATTERING_RAM: rollNeeded = game.batteringRamStrength(); break;
            case LADDER: rollNeeded = game.ladderStrength(); break;
            case SIEGE_TOWER: rollNeeded = game.siegeTowerStrength(); break;
            case CLOSE_COMBAT: rollNeeded = 4; break;
            case RALLY_TROOPS: rollNeeded = 4; break;
            case BOOST_RALLY_TROOPS: rollNeeded = 3; break;
            case COUPURE_ROLL: rollNeeded = 4; break;
            default: return;
        }
        System.out.format("You need a roll greater than %d\n", rollNeeded);
        System.out.print("Press ENTER to see your roll");
        enter.nextLine();
        System.out.format("You got %d\n", game.getLastRoll());
        if (game.getLastRoll() > rollNeeded) {
            System.out.print("Nice, you won the roll!!");
        } else { System.out.print("Ohh, you lost the roll!!"); }
        System.out.println("Press ENTER to continue...");
        enter.nextLine();
    }
}
