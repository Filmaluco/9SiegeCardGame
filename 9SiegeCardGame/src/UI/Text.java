package UI;

import Controllers.GameController;
import Controllers.states.*;
import SiegeCard.Util.rolls;
import SiegeCard.Util.str_values;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Text implements str_values, rolls {

    private Scanner scanner;
    private BufferedReader reader;
    private GameController game;

    public Text(GameController gameController){
        this.game=gameController;
        scanner=new Scanner(System.in);
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    private int readOption(){
        System.out.println("Choose your option: ");
        while(!scanner.hasNextInt()) scanner.next();
        return scanner.nextInt();
    }

    private String readLine(){
        String line="";
        try {                    line=reader.readLine().trim();
        } catch (IOException e) {System.out.println(e);}
        return line;
    }

    private void printLogo(){
        System.out.println("  ___  _____            __  \n" +
                " / _ \\/ ___/__ ________/ /  \n" +
                " \\_, / /__/ _ `/ __/ _  /   \n" +
                "/___/\\___/\\_,_/_/  \\_,_/    \n" +
                "   _____                    \n" +
                "  / __(_)__ ___ ____        \n" +
                " _\\ \\/ / -_) _ `/ -_)       \n" +
                "/___/_/\\__/\\_, /\\__/        \n" +
                "          /___/             ");
    }

    private void printMenu(String[] options){
        for (int i = 0; i < options.length; i++)
            System.out.println(i+1+ "-" + options[i]);
    }

    private void printOptionsMenu(String[] options){
        for (int i = 0; i < options.length; i++){
            System.out.print(i+1+ "-");
            //Checks if it needs to Set or Change Name
            if(i==0)
                System.out.print(game.hasInitialConfig()?nameOptions[0]:nameOptions[1]);
            System.out.println(options[i]);
        }
    }

    private void printPlayMenu(String[] options){
        for (int i = 0; i < options.length; i++){
            switch (i){
                case 0:
                    if(!(game.getGameData().canArchersAttack())) break;
                case 1:
                    if(!(game.getGameData().canBoilAttack())) break;
                case 2:
                    if(!(game.getGameData().canCloseCombat())) break;
                case 3:
                    if(!(game.getGameData().canCoupure())) break;
                case 4:
                    if(!(game.getGameData().canRallyTroops())) break;
                case 5:
                    if(!(game.getGameData().canUseTunnelMovemnt())) break;
                case 6:
                    if(!(game.getGameData().canSupplyRaid())) break;
                case 7:
                    if(!(game.getGameData().canSabotage())) break;
                default:
                    System.out.println(i+1+ "-"+options[i]);
            }
        }
    }

    public final static void clearScreen()
    {
        //Todo: Test
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public void start(){

        while (!(game.getState()instanceof GameExit)) {
            //TODO: Implement other states!!
            if (game.getState() instanceof GameSetup) {
                mainMenu();
            } else if (game.getState() instanceof ActionPhase) {
                playMenu();
            } else if (game.getState() instanceof CardPhase){
                cardPhaseMenu();
            } else if (game.getState() instanceof ActionArchersAttack){
                archersAttackMenu();
            } else if (game.getState() instanceof GameOver){
                gameOverMenu();
            } else if (game.getState() instanceof GameWon){
                gameWonMenu();
            }
        }
    }

    public void mainMenu() {
        int option;

            clearScreen();
            printLogo();
            printMenu(mainMenuOptions);
            option = readOption();

        switch (option) {
            case 1:
                //TODO Implement gameplay, check loadexist and config conditions
                if (!game.hasInitialConfig()) {
                    System.out.print(nameOptions[2]);
                    game.setInitialConfig(readLine());
                }
                clearScreen();
                game.Start();
                //TODO: Maybe Implement in a new Card Menu?
                //game.StartTurn();
                break;

            case 2:
                clearScreen();
                configsMenu();
                break;

            case 3:
                //TODO: Implement load from file
                System.out.println("Loading...\n");
                break;

            case 4:
                game.Exit();
                System.out.println("Exiting...\n");
                break;

            default:
                System.out.println(errorMessage[0]);
                break;
        }

    }

    public void configsMenu(){
        int option;
        do{
            clearScreen();
            printLogo();
            printOptionsMenu(configsOptions);
            option=readOption();

            switch (option){
                case 1:
                    System.out.print(nameOptions[2]);
                    game.setInitialConfig(readLine());
                    break;

                case 2:
                    break;

                default:
                    System.out.println(errorMessage[0]);
                    break;
            }
        }while (option!=2);
    }

    public void playMenu(){
        int option;
        //TODO: Change do while to end in instanceof GAMEOVER or Save and Exit
        //TODO: Complete the UI with trackers and day
        //TODO:

        clearScreen();
        printLogo();
        System.out.println(game.toString() + "\n");
        printPlayMenu(playMenuOptions);
        option = readOption();

        switch (option) {
            case 1:
                game.ArchersAttack();
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                game.EndTurn();

                break;

            case 10:
                game.Exit();
                break;

            default:
                System.out.println(errorMessage[0]);
                break;
        }

    }

    public void cardPhaseMenu(){
        //System.out.println("You managed to survive another turn, moving on to the next one!");
        System.out.println("Lets start a turn!!");
        game.StartTurn();
    }

    public void gameOverMenu(){
        int option;
        //TODO: Add how many turns and days player lastedfff
        System.out.println("You lost\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=readOption();

        if (option == 1) { game.Menu(); } else { game.Exit(); }

    }

    public void gameWonMenu(){
        int option;
        System.out.println("You Won!!\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=readOption();

        if (option == 1) { game.Menu(); } else { game.Exit(); }
    }

    public void archersAttackMenu(){
        int target;
        System.out.println("Preparing archers to attack!");
        target=enemySelect();
        game.ApplyRules(target);
    }

    public int enemySelect(){
        int option=0;

        System.out.println("Which enemy do you wish to attack: \n1-Battering Ram\n2-Ladder\n3-Siege Tower");

        do {
            option = readOption();
            switch (option) {
                case 1:
                    return BATTERING_RAM;
                case 2:
                    return LADDER;
                case 3:
                    return SIEGE_TOWER;

                default:
                    System.out.println("Wrong Option!");
                    break;
            }
        }while (true);

    }
}
