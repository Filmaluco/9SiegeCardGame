package UI.Text;

import Controllers.GameController;
import SiegeCard.Util.Constants;
import UI.Text.Util.Read;

import static SiegeCard.Util.Constants.MORALE;
import static SiegeCard.Util.Constants.SUPPLY;

public class AdicionalPointMenu {

    private Read read;
    int option;
    Constants target;

    public AdicionalPointMenu() {
        read = new Read();
    }

    public void menu(GameController game){

        System.out.println("Do you wish to trade a Morale or Supply Point for an additional action?");
        System.out.println("1-Morale\n2-Supply Point");
        option=read.option();

        if (option == 1) { target=MORALE; }
        if (option == 2) { target=SUPPLY; }

        game.ApplyRules(target);
    }
}
