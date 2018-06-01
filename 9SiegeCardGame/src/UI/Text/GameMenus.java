package UI.Text;

import Controllers.GameController;
import UI.Text.Util.Read;

public class GameMenus {

    private Read read;
    private String playerName;
    private GameController newGame;
    int option;

    public GameMenus() {
        newGame = new GameController();
        read = new Read();
    }

    public GameController overMenu(GameController game){
        System.out.println("You lost\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=read.option();

        if (option == 0) { game.Exit();}
        if (option == 1) {
            playerName=game.getPlayerName();
            newGame.setInitialConfig(playerName);
            return newGame;
        }
        return game;
    }

    public GameController wonMenu(GameController game){
        System.out.println("You Won!!\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=read.option();

        if (option == 0) { game.Exit();}
        if (option == 1) {
            playerName=game.getPlayerName();
            newGame.setInitialConfig(playerName);
            return newGame;
        }
        return  game;
    }
}
