package UI.Text;

import Controllers.GameController;
import SiegeCard.Util.Rolls;
import UI.Text.Util.Read;
import UI.Text.Util.Roll;

import static SiegeCard.Util.Rolls.BATTERING_RAM;
import static SiegeCard.Util.Rolls.LADDER;
import static SiegeCard.Util.Rolls.SIEGE_TOWER;

public class ArchersAttackMenu {

    private Read read;
    private Roll roll;
    int option;

    public ArchersAttackMenu() { read = new Read(); }

    public void menu(GameController game){
        roll = new Roll(game);
        Rolls target;
        System.out.println("Preparing archers to attack!");
        target=enemySelect(game);
        game.ApplyRules(target);
        roll.yourRoll(target);
    }

    private Rolls enemySelect(GameController game){
        System.out.println("Which enemy do you wish to attack: \n");

        System.out.format(game.batteringRamOnStartingSpace()?"":"1-Battering Ram\n");
        System.out.format(game.ladderOnStartingSpace()?"":"2-Ladder\n");
        System.out.format(game.siegeTowerOnStartingSpace()?"":"3-Siege Tower\n");

        do {
            option = read.option();
            switch (option) {
                case 1:
                    if(!game.batteringRamOnStartingSpace()){ return BATTERING_RAM; } break;
                case 2:
                    if(!game.ladderOnStartingSpace()){ return LADDER; } break;
                case 3:
                    if(!game.siegeTowerOnStartingSpace()){ return SIEGE_TOWER; } break;
                default:
                    System.out.println("Wrong Option!"); break;
            }
        }while (true);
    }
}
