package UI.Graphical.Util;

import java.awt.*;

public interface Miscellaneous {

    //Font Constants
    Font MAIN_MENU_FONT = new Font("Arial", Font.PLAIN, 40);
    Font SUPPLIES_FONT = new Font("Arial", Font.PLAIN, 65);
    Font PLAYER_INFO_FONT = new Font("Arial", Font.PLAIN, 25);
    Font DIALOG_BOX_FONT = new Font("Arial", Font.PLAIN, 15);
    Font DICE_FONT = new Font("Arial", Font.PLAIN, 20);

    //Card Layout Constants
    String MAIN_MENU = "MAIN MENU";
    String GAME = "GAME";

    String ENEMY_TRACKER = "ENEMY TRACKER";
    String TUNNEL_TRACKER = "TUNNEL TRACKER";

    //Tooltip Constants
    //TODO: Complete
    String TUNNEL_VIEW = "Tunnel View";
    String ENEMY_TRACKER_VIEW = "Enemy Tracker View";
    String SABOTAGE_ACTION = "Sabotage Action";
    String RALLY_TROOPS_ACTION = "Rally Troops Action";

    //Dialog Box Constants
    String DIALOG_BOX_RALLY_TROOPS_MENU = "Rally Troops Action";
    String DIALOG_BOX_RALLY_TROOPS_TEXT = "Do you wish to trade one supply point to get a +1 DRM?";
    String DIALOG_BOX_OPTION_YES = "Yes";
    String DIALOG_BOX_OPTION_NO = "No";
    Object[] DIALOG_BOX_RALLY_TROOPS_OPTIONS = {DIALOG_BOX_OPTION_YES, DIALOG_BOX_OPTION_NO};

    String DIALOG_BOX_ADDITIONAL_POINT_MENU = "Additional Point Action";
    String DIALOG_BOX_ADDITIONAL_POINT_TEXT = "Do you wish to trade a morale or supply point for an additional action?";
    String DIALOG_BOX_OPTION_SUPPLY = "Supply";
    String DIALOG_BOX_OPTION_MORALE = "Morale";
    Object[] DIALOG_BOX_ADDITIONAL_POINT_OPTIONS = {DIALOG_BOX_OPTION_SUPPLY, DIALOG_BOX_OPTION_MORALE};

    String DIALOG_BOX_PLAYER_NAME_MENU = "Player Name";
    String DIALOG_BOX_PLAYER_NAME_TEXT = "Please enter your player name to start the game!";

    //Dice Constants
    String DICE_ROLL_NEEDED = "You need a roll greater than:";
    String DICE_LAST_ROLL = "You got:";
    String DICE_WON_ROLL = "Nice! You Won the roll, let's move on!";
    String DICE_LOST_ROLL = "Ups! You Lost the roll, better luck next time!";
    String DICE_CONTINUE = "Continue!";

    //Menu Bar Constants
    String MENU_GAME = "Game Menu";
    String MENU_SAVE_GAME = "Save Game";
    String MENU_LOAD_GAME = "Load Game";
    String MENU_EXIT = "Exit Game";

}
