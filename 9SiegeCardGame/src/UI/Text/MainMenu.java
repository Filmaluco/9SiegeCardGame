package UI.Text;

import Controllers.GameController;
import Controllers.SavesController;
import UI.Text.Util.Print;
import UI.Text.Util.Read;

import java.io.IOException;

import static SiegeCard.Util.str_values.*;

public class MainMenu {

    private GameController game;
    private SavesController savesGame;
    private ConfigsMenu configs;
    private Read read;
    int option;

    public MainMenu(GameController game) {
        this.game = game;
        savesGame = new SavesController();
        configs = new ConfigsMenu();
        read = new Read();
    }

    public GameController menu(GameController game) {
        Print.logo();
        Print.menu(mainMenuOptions);
        option = read.option();

        switch (option) {
            case 1:
                //TODO Implement gameplay, check loadexist and config conditions
                if (!game.hasInitialConfig()) {
                    System.out.print(nameOptions[2]);
                    game.setInitialConfig(read.line());
                }
                game.Start();
                break;

            case 2:
                configs.menu(game);
                break;

            case 3:
                System.out.println("What was your Player name?");
                String name = read.line();
                try {
                     game = savesGame.loadGame(name);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("No record for thar player name...");
                }
                break;

            case 4:
                game.Exit();
                break;

            default:
                System.out.println(errorMessage[0]);
                break;
        }
        return game;
    }
}
