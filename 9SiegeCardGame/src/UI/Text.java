package UI;

import SiegeCard.Util.str_values;

import java.util.Scanner;

public class Text implements str_values {

    Scanner scanner = new Scanner(System.in);

    private int readOption(){
        System.out.println("Choose your option: ");
        while(!scanner.hasNextInt()) scanner.next();
        return scanner.nextInt();
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

    protected void printMenu(String[] options){
        for (int i = 0; i < options.length; i++)
            System.out.println(i+1+ "-" + options[i]);
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
                case 1: {
                    //TODO Implement gameplay, check loadexist and config conditions
                    clearScreen();
                    System.out.println("Playing...\n");
                }break;

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

                default:{
                    System.out.println("Wrong Option\n");
                }break;
            }

        } while (option!=4);

    }

    public void configsMenu(){
        int option=0;
        do{
            clearScreen();
            printLogo();
            printMenu(configsOptions);
            option=readOption();

            switch (option){
                case 1:
                    //TODO implement change player name
                    break;

                case 2:
                    break;

                default:{
                    System.out.println("Wrong Option\n");
                }break;
            }
        }while (option!=2);

    }



}
