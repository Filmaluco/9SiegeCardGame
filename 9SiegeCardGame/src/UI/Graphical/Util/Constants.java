package UI.Graphical.Util;

import static Models.EnemyTrackerModel.MAX_TREBUCHET;

public interface Constants {
    int NUMBER_OF_CARDS = 7;

    int DIM_X_FRAME = 1024;
    int DIM_Y_FRAME = 768;

    //Grid X is divided by 8
    int DIM_X_8 = DIM_X_FRAME/8;
    //Grid Y is divided by 7
    int DIM_Y_7 = DIM_Y_FRAME/7;

    //Icons Dimensions
    int DIM_X_ICONS = 87;
    int DIM_Y_ICONS = 86;

    //Main Menu
    int DIM_X_MENU = DIM_X_8*4 + DIM_Y_7;//588;
    int DIM_Y_MENU = DIM_Y_FRAME / 2;

    int DIM_X_MENU_BUTTON = 588;
    int DIM_Y_MENU_BUTTON = 83;

    int DIM_X_MENU_BUTTON_BORDER = 110;
    int DIM_Y_MENU_BUTTON_BORDER = 30;

    //NavBar
    int DIM_X_PLAYERINFO = DIM_X_FRAME;
    int DIM_Y_PLAYERINFO = 40;

    //Player Status Track
    int DIM_X_SUPPLIES_BORDER = DIM_Y_7/4;

    int DIM_X_SUPPLIES = DIM_X_8 + DIM_X_8/2 - DIM_X_SUPPLIES_BORDER; //150;
    int DIM_Y_SUPPLIES = DIM_Y_7*3;

    int DIM_X_STATUS_TRACK = DIM_X_8 + DIM_X_8/6;
    int DIM_Y_STATUS_TRACK = DIM_Y_7;
    int DIM_X_STATUS_TRACK_BORDER = DIM_Y_7/2;
    int DIM_Y_STATUS_TRACK_BORDER = 0;

    //Tunnel Constants
    int DIM_X_TUNNEL_ICON = 83;
    int DIM_Y_TUNNEL_ICON = 83;

    //Enemy Tracker
    int DIM_X_ENEMY_GUI = DIM_X_8 * 4 + DIM_X_8/2;
    int DIM_Y_ENEMY_GUI = DIM_Y_7*3;

    int DIM_ENEMY_X_BORDER = DIM_Y_7/5;
    int DIM_ENEMY_Y_BORDER = DIM_Y_7/10;

    int DIM_X_ENEMY = DIM_X_8 * 5 + DIM_X_8/6;
    int DIM_Y_ENEMY = DIM_Y_7 - DIM_ENEMY_Y_BORDER;

    int DIM_X_COMBAT_LABEL = 95;
    int DIM_Y_COMBAT_LABEL = 96;

    int DIM_X_CIRCLE_COMBAT_LABEL = 83;
    int DIM_Y_CIRCLE_COMBAT_LABEL = 83;

    int DIM_X_CLOSE_COMBAT_LABEL = 66;
    int DIM_Y_CLOSE_COMBAT_LABEL = 66;

    int DIM_X_TREBUCHET_LABEL = 88;
    int DIM_Y_TREBUCHET_LABEL = 87;

    int DIM_X_TREBUCHET_BORDER = 0;
    int DIM_Y_TREBUCHET_BORDER = 13;

    int DIM_X_TREBUCHET_GUI = DIM_X_8 + DIM_ENEMY_X_BORDER;
    int DIM_Y_TREBUCHET_GUI = DIM_Y_ENEMY_GUI;

    //Deck
    int DIM_X_DECK_DISPLAY = DIM_X_8 * 5 + DIM_Y_7/2;
    int DIM_Y_DECK_DISPLAY = DIM_Y_7 * 2;

    int DIM_X_CARD_SIZE = 158;
    int DIM_Y_CARD_SIZE = 220;

    //Dialog Box
    int DIM_X_DIALOG_BOX = 450;
    int DIM_Y_DIALOG_BOX = 275;

    int DIM_X_DIALOG_BOX_BUTTON = 154;
    int DIM_Y_DIALOG_BOX_BUTTON = 52;

    //Dice Dimensions
    int DIM_X_DICE = DIM_X_FRAME/2;
    int DIM_Y_DICE = DIM_X_FRAME/2;

    int DIM_X_DICE_IMAGE = 85;
    int DIM_Y_DICE_IMAGE = 86;

    int DIM_DICE_BORDER = 20;

    int DIM_X_DICE_LABEL = DIM_X_DICE/3;
    int DIM_Y_DICE_LABEL = DIM_Y_DICE/3;
}
