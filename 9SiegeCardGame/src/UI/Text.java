package UI;

import Controllers.GameController;
import Controllers.SavesController;
import Controllers.states.*;
import SiegeCard.Util.rolls;
import SiegeCard.Util.str_values;

import java.io.*;
import java.util.Scanner;

import static SiegeCard.Util.constants.FREE_MOVEMENT;
import static SiegeCard.Util.constants.MORALE;
import static SiegeCard.Util.constants.SUPPLY;

public class Text implements str_values, rolls {

    private Scanner scanner;
    private BufferedReader reader;
    private GameController game;
    private SavesController savesGame;

    public Text(GameController gameController){
        this.game=gameController;
        savesGame= new SavesController();
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
            } else if (game.getState() instanceof ActionTunnelMovement) {
                tunelMovementMenu();
            }else if (game.getState() instanceof GameOver){
                gameOverMenu();
            } else if (game.getState() instanceof GameWon){
                gameWonMenu();
            }
        }
    }



    private void mainMenu() {
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
                break;

            case 2:
                configsMenu();
                break;

            case 3:
                System.out.println("What was your Player name?");
                String name = readLine();
                try {
                    game=savesGame.loadGame(name);
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

    }

    private void configsMenu(){
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

    private void playMenu(){
        int option;

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
                game.Tunel();
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
                if(savesGame.saveGame(game,game.getPlayerName())){
                    System.out.println("Saved successfully!");
                }else{
                    System.out.println("Error could not save...");
                }
                game.Exit();
                break;

            default:
                System.out.println(errorMessage[0]);
                break;
        }

    }

    private void tunelMovementMenu() {
        //TODO: Implement

        if(game.canMoveInTunnel()){
            int option;
            System.out.println("Which option do you wanne use?");
            if(game.canUseFreeMovement()){
                System.out.println("1-Free Movement");
            }
            if(game.canUseFastMovement()){
                System.out.println("2-Fast Movement");
            }
            System.out.println("3- go back");
            option=readOption();
            if(option == 3)game.ApplyRules(0);
            game.MoveInTunnel(option);
        }else if(game.canMoveIntoTunnel()){
            int option;
            System.out.println("Would you like to enter the tunnel (1 action Point)");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            option=readOption();
            if(option == 1) game.MoveIntoTunnel();
            if(option == 2) game.ApplyRules(0);
        }else {
            game.ApplyRules(0);
        }
    }

    private void cardPhaseMenu(){
        //System.out.println("You managed to survive another turn, moving on to the next one!");
        System.out.println("Lets start a turn!!");
        game.StartTurn();
    }

    private void closeCombatMenu(){
        if(game.canCloseCombat()) {
            System.out.println("Entering close combat!!");
            game.CloseCombat();
            yourRoll(CLOSE_COMBAT);
        }
    }

    private void gameOverMenu(){
        int option;
        System.out.println("You lost\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=readOption();

        if (option == 1) { game.Menu(); } else { game.Exit(); }

    }

    private void gameWonMenu(){
        int option;
        System.out.println("You Won!!\n Do you wish to go back to the main menu?\n 1 - Yes\n 0 - No, Exit");

        option=readOption();

        if (option == 1) { game.Menu(); } else { game.Exit(); }
    }

    private void archersAttackMenu(){
        int target;
        System.out.println("Preparing archers to attack!");
        target=enemySelect();
        game.ApplyRules(target);
        yourRoll(target);
    }

    private void boilingAttackMenu(){
        int target;
        System.out.println("Preparing to boil!");
        target=enemySelect();
        game.ApplyRules(target);
        yourRoll(target);
    }

    private void coupureMenu(){
        if(game.canCoupure()) {
            System.out.println("Preparing to repair damage to the wall");
            game.Coupure();
            yourRoll(COUPURE_ROLL);
        }
    }

    private void adicionalPointMenu(){
        int option;
        int target;
        System.out.println("Do you wish to trade a Morale or Supply Point for an additional action?");
        System.out.println("1-Morale\n2-Supply Point");
        option=readOption();

        if (option == 1) { target=MORALE; } else { target=SUPPLY; }

        game.ApplyRules(target);

    }

    private void rallyTroopsMenu(){
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

    private void yourRoll(int target){
        int rollNeeded;
        Scanner enter = new Scanner(System.in);

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

    private int enemySelect(){
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
