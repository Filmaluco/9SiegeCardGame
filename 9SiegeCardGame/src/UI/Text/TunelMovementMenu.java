package UI.Text;

import Controllers.GameController;
import UI.Text.Util.Read;

import static SiegeCard.Util.Constants.AUTO_MOVMENT;
import static SiegeCard.Util.Constants.FAST_MOVEMENT;
import static SiegeCard.Util.Constants.FREE_MOVEMENT;

public class TunelMovementMenu {

    private Read read;
    int option;

    public TunelMovementMenu() {
        read = new Read();
    }

    public void menu(GameController game) {
        if(game.canMoveInTunnel()){
            System.out.println("Which option do you wanne use?");
            if(game.canUseFreeMovement()){
                System.out.println("1-Free Movement");
            }
            if(game.canUseFastMovement()){
                System.out.println("2-Fast Movement");
            }
            System.out.println("3- go back");
            option=read.option();
            if(option == 1)game.MoveInTunnel(FREE_MOVEMENT);
            if(option == 2)game.MoveInTunnel(FAST_MOVEMENT);
            if(option == 3)game.ApplyRules(AUTO_MOVMENT);

        }else if(game.canMoveIntoTunnel()){
            System.out.println("Would you like to enter the tunnel (1 action Point)");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            option=read.option();
            if(option == 1) game.MoveIntoTunnel();
            if(option == 2) game.ApplyRules(AUTO_MOVMENT);
        }else {
            game.ApplyRules(AUTO_MOVMENT);
        }
    }
}
