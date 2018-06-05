package UI.Text;

import Controllers.GameController;

public class CardPhaseMenu {

    public void menu(GameController game){
        if(game.getGameData().getCurrentTurn()==1){
            System.out.println("Starting a turn on a new day!!");
        }else{
            System.out.println("You managed to survive another turn, moving on to the next one!!");
        }
        game.StartTurn();
    }
}
