package UI.Text;

import Controllers.GameController;
import SiegeCard.Util.Rolls;
import UI.Text.Util.Read;
import UI.Text.Util.Roll;

import static SiegeCard.Util.Rolls.BATTERING_RAM;
import static SiegeCard.Util.Rolls.LADDER;
import static SiegeCard.Util.Rolls.SIEGE_TOWER;

public class BoilAttackMenu {

    private Read read;
    private Roll roll;
    int option;
    Rolls target;

    public BoilAttackMenu() {
        read = new Read();
    }

    public void menu(GameController game){
        roll = new Roll(game);
        System.out.println("Preparing to boil!");
        target=enemySelectBoilAttack(game);
        game.ApplyRules(target);
        roll.yourRoll(target);
    }

    private Rolls enemySelectBoilAttack(GameController game){
        System.out.println("Which enemy do you wish to boil: \n");

        System.out.format(!game.batteringRamOnCircleSpace()?"":"1-Battering Ram\n");
        System.out.format(!game.ladderOnCircleSpace()?"":"2-Ladder\n");
        System.out.format(!game.siegeTowerOnCircleSpace()?"":"3-Siege Tower\n");

        do {
            option = read.option();
            switch (option) {
                case 1:
                    if(game.batteringRamOnCircleSpace()){ return BATTERING_RAM; } break;
                case 2:
                    if(game.ladderOnCircleSpace()){ return LADDER; } break;
                case 3:
                    if(game.siegeTowerOnCircleSpace()){ return SIEGE_TOWER; } break;
                default:
                    System.out.println("Wrong Option!");
                    break;
            }
        }while (true);
    }
}
