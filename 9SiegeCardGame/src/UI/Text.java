package UI;

import Controllers.GameController;
import Controllers.states.*;
import SiegeCard.Util.rolls;
import SiegeCard.Util.str_values;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static SiegeCard.Util.constants.MORALE;
import static SiegeCard.Util.constants.SUPPLY;

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
                        System.out.println(i+1+ "-"+options[i]);break;

                default:
                    System.out.println(i+1+ "-"+options[i]);
            }
        }
    }

    public void start(){

        while (!(game.getState()instanceof GameExit)) {
            //TODO: Implement other states!!
            if (game.getState() instanceof GameSetup) {
                mainMenu();
            } else if (game.getState() instanceof ActionPhase) {
                playMenu();
            } else if (game.getState() instanceof CardPhase) {
                cardPhaseMenu();
            } else if (game.getState() instanceof ActionArchersAttack) {
                archersAttackMenu();
            } else if (game.getState() instanceof ActionBoilingAttack) {
                boilingAttackMenu();
            } else if (game.getState() instanceof ActionRallyTroops){
                rallyTroopsMenu();
            } else if (game.getState() instanceof ActionAdicionalPoint){
                adicionalPointMenu();
            } else if (game.getState() instanceof GameOver){
                gameOverMenu();
            } else if (game.getState() instanceof GameWon){
                gameWonMenu();
            }
        }
    }

    public void mainMenu() {
        int option;

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
                game.Start();
                //TODO: Maybe Implement in a new Card Menu?
                //game.StartTurn();f
                break;

            case 2:
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

        printLogo();
        System.out.println(game.toString() + "\n");
        printPlayMenu(playMenuOptions);
        option = readOption();

        switch (option) {
            case 1:
                game.ArchersAttack();
                break;

            case 2:
                game.BoilingAttack();
                break;

            case 3:
                closeCombatMenu();
                break;

            case 4:
                coupureMenu();
                break;

            case 5:
                game.RallyTroops();
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                game.Adicional();
                break;

            case 10:
                game.EndTurn();

                break;

            case 11:
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

    public void closeCombatMenu(){
        if(game.canCloseCombat()) {
            System.out.println("Entering close combat!!");
            game.CloseCombat();
            yourRoll(CLOSE_COMBAT);
        }
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
        yourRoll(target);
    }

    public void boilingAttackMenu(){
        int target;
        System.out.println("Preparing to boil!");
        target=enemySelect();
        game.ApplyRules(target);
        yourRoll(target);
    }

    public void coupureMenu(){
        if(game.canCoupure()) {
            System.out.println("Preparing to repair damage to the wall");
            game.Coupure();
            yourRoll(COUPURE_ROLL);
        }
    }

    public void adicionalPointMenu(){
        int option;
        int target;
        System.out.println("Do you wish to trade a Morale or Supply Point for an additional action?");
        System.out.println("1-Morale\n2-Supply Point");
        option=readOption();

        if (option == 1) { target=MORALE; } else { target=SUPPLY; }

        game.ApplyRules(target);

    }

    public void rallyTroopsMenu(){
        int option;
        int target=RALLY_TROOPS;
        System.out.println("Preparing to be motivational!");
        if(game.getMorale()>0) {
            System.out.println("Do you want to trade one supply to get a +1 DRM?\n1-Yes\n0-No");
            option = readOption();
            if (option == 1) {
                target=BOOST_RALLY_TROOPS;
                game.ApplyRules(target);
            } else {
                game.ApplyRules(target);
            }
        }else{
            game.ApplyRules(target);
        }
        yourRoll(target);
    }

    public void yourRoll(int target){
        int rollNeeded;
        Scanner enter = new Scanner(System.in);

        //TODO: Check if on close combat

        switch (target){
            case BATTERING_RAM:
                rollNeeded = game.batteringRamStrength();
                break;
            case LADDER:
                rollNeeded = game.ladderStrength();
                break;
            case SIEGE_TOWER:
                rollNeeded = game.siegeTowerStrength();
                break;
            case CLOSE_COMBAT:
                rollNeeded = 4;
                break;
            case RALLY_TROOPS:
                rollNeeded = 4;
                break;
            case BOOST_RALLY_TROOPS:
                rollNeeded = 3;
                break;
            case COUPURE_ROLL:
                rollNeeded = 4;
                break;

                default:
                    return;
        }
        System.out.format("You need a roll greater than %d\n", rollNeeded);
        System.out.print("Press ENTER to see your roll");
        enter.nextLine();
        System.out.format("You got %d\n", game.getLastRoll());
        if (game.getLastRoll() > rollNeeded) {
            System.out.print("Nice, you won the roll!!");
        } else { System.out.print("Ohh, you lost the roll!!"); }
        System.out.println("Press ENTER to continue...");
        enter.nextLine();
    }

    public int enemySelect(){
        int option=0;

        System.out.println("Which enemy do you wish to attack: \n");

        System.out.format(game.batteringRamOnStartingSpace()?"":"1-Battering Ram\n");
        System.out.format(game.ladderOnStartingSpace()?"":"2-Ladder\n");
        System.out.format(game.siegeTowerOnStartingSpace()?"":"3-Siege Tower\n");

        do {
            option = readOption();
            switch (option) {
                case 1:
                    if(!game.batteringRamOnStartingSpace()){
                        return BATTERING_RAM;
                    }
                    break;
                case 2:
                    if(!game.ladderOnStartingSpace()){
                        return LADDER;
                    }
                    break;
                case 3:
                    if(!game.siegeTowerOnStartingSpace()){
                        return SIEGE_TOWER;
                    }
                    break;

                default:
                    System.out.println("Wrong Option!");
                    break;
            }
        }while (true);

    }
}
