package UI;

import Controllers.GameController;
import SiegeCard.Util.str_values;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Text implements str_values {

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
            System.out.print(i+1+ "-");
            //TODO: Implement Check Boiling Water
            //Checks if Boiling Water was used in the turn
//            if(i==2)
//                System.out.print(game.hasInitialConfig()?nameOptions[0]:nameOptions[1]);
            System.out.println(options[i]);
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


    public void mainMenu() {
        int option;

        do {
            clearScreen();
            printLogo();
            printMenu(mainMenuOptions);
            option = readOption();

            switch (option) {
                case 1:
                    //TODO Implement gameplay, check loadexist and config conditions
                    if(!game.hasInitialConfig()){
                        System.out.print(nameOptions[2]);
                        game.setInitialConfig(readLine());
                    }
                    clearScreen();
                    playMenu();
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
                    System.out.println("Exiting...\n");
                    break;

                default:
                    System.out.println(errorMessage[0]);
                    break;
            }

        } while (option!=4);
        //TODO: Change to instanceof GameOver
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
        do {
            clearScreen();
            printLogo();
            System.out.println(game.toString()+"\n");
            printPlayMenu(playMenuOptions);
            option=readOption();

            switch (option){
                case 1:
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
                    break;

                default:
                    System.out.println(errorMessage[0]);
                    break;
            }
        }while (option!=9);
    }
}
