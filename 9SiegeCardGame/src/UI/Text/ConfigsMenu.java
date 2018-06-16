package UI.Text;

import Controllers.GameController;
import UI.Text.Util.Print;
import UI.Text.Util.Read;

import static SiegeCard.Util.Str_Values.*;

public class ConfigsMenu {

    private Read read;
    int option;

    public ConfigsMenu() {
        read = new Read();
    }

    public void menu(GameController game){
        do{
            Print.logo();
            printOptionsMenu(game,configsOptions);
            option=read.option();

            switch (option){
                case 1:
                    System.out.print(nameOptions[2]);
                    game.setInitialConfig(read.line());
                    break;
                case 2:
                    break;
                default:
                    System.out.println(errorMessage[0]); break;
            }
        }while (option!=2);
    }

    private void printOptionsMenu(GameController game,String[] options){
        for (int i = 0; i < options.length; i++){
            System.out.print(i+1+ "-");
            //Checks if it needs to Set or Change Name
            if(i==0)
                System.out.print(game.hasInitialConfig()?nameOptions[0]:nameOptions[1]);
            System.out.println(options[i]);
        }
    }

}
