package UI.Text;

import Controllers.GameController;
import Controllers.SavesController;
import UI.Text.Util.Print;
import UI.Text.Util.Read;

import static SiegeCard.Util.Str_Values.*;

public class PlayMenu {

    private SavesController savesGame;
    private CloseCombatMenu closeCombatMenu;
    private CoupureMenu coupureMenu;
    private Read read;
    int option;

    public PlayMenu() {
        savesGame = new SavesController();
        closeCombatMenu = new CloseCombatMenu();
        coupureMenu = new CoupureMenu();
        read = new Read();
    }

    public void menu(GameController game){
        Print.logo();
        System.out.println(game.toString() + "\n");
        printPlayMenu(game ,playMenuOptions);
        option = read.option();

        switch (option) {
            case 1: game.ArchersAttack(); break;
            case 2: game.BoilingAttack(); break;
            case 3: closeCombatMenu.menu(game); break;
            case 4: coupureMenu.menu(game); break;
            case 5: game.RallyTroops(); break;
            case 6: game.Tunel(); break;
            case 7: break;
            case 8: break;
            case 9: game.Adicional(); break;
            case 10: game.EndTurn(); break;
            case 11:
                if(savesGame.saveGame(game,game.getPlayerName())){
                    System.out.println("Saved successfully!");
                }else{
                    System.out.println("Error could not save...");
                }
                game.Exit();
                break;
            default: System.out.println(errorMessage[0]); break;
        }
    }

    private void printPlayMenu(GameController game,String[] options){
        for (int i = 0; i < options.length; i++){
            switch (i){
                case 0:
                    if((game.canArchersAttack()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 1:
                    if((game.canBoilAttack()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 2:
                    if((game.canCloseCombat()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 3:
                    if((game.canCoupure()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 4:
                    if((game.canRallyTroops()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 5:
                    if((game.canUseTunnelMovemnt()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 6:
                    if((game.canSupplyRaid()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 7:
                    if((game.canSabotage()))
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                case 8:
                    if(game.canGetAdicionalPoint())
                        System.out.println(i+1+ "-"+options[i]);
                    break;
                default:
                    System.out.println(i+1+ "-"+options[i]);
            }
        }
    }
}
