package UI.Graphical;

import java.awt.*;

import static Models.EnemyTrackerModel.MAX_TREBUCHET;

public interface Constants {

    Font SUPPLIES_FONT = new Font("Arial", Font.PLAIN, 65);

    String MAIN_MENU = "MAIN MENU";
    String GAME = "GAME";

    int DIM_X_FRAME = 1024;
    int DIM_Y_FRAME = 768;

    int DIM_X_MENU = 588;
    int DIM_Y_MENU = DIM_Y_FRAME / 2;

    int DIM_X_MENU_BUTTON = 588;
    int DIM_Y_MENU_BUTTON = 83;

    int DIM_X_MENU_BUTTON_BORDER = 110;
    int DIM_Y_MENU_BUTTON_BORDER = 30;

    int DIM_X_PLAYERINFO = DIM_X_FRAME;
    int DIM_Y_PLAYERINFO = 40;

    int DIM_X_SUPPLIES = 150;
    int DIM_Y_SUPPLIES = 300;

    int DIM_X_STATUS_TRACK = 87;
    int DIM_Y_STATUS_TRACK = 86;
    int DIM_X_STATUS_TRACK_BORDER = 50;
    int DIM_Y_STATUS_TRACK_BORDER = 25;

//    int DIM_X_ENEMY_GUI = ;
//    int DIM_Y_ENEMY_GUI = ;

    int DIM_ENEMY_X_BORDER = 20;
    int DIM_ENEMY_Y_BORDER = 10;

    int DIM_X_COMBAT_LABEL = 95;
    int DIM_Y_COMBAT_LABEL = 96;

    int DIM_X_CIRCLE_COMBAT_LABEL = 83;
    int DIM_Y_CIRCLE_COMBAT_LABEL = 83;

    int DIM_X_TREBUCHET_LABEL = 88;
    int DIM_Y_TREBUCHET_LABEL = 87;

    int DIM_X_TREBUCHET_GUI = DIM_X_TREBUCHET_LABEL + DIM_ENEMY_X_BORDER;
    int DIM_Y_TREBUCHET_GUI = DIM_Y_TREBUCHET_LABEL * MAX_TREBUCHET + DIM_ENEMY_Y_BORDER * MAX_TREBUCHET;

    int DIM_X_ENEMY_TRACK = DIM_X_TREBUCHET_GUI;
    int DIM_Y_ENEMY_TRACK = DIM_Y_TREBUCHET_GUI;

    int DIM_X_ICONS = 87;
    int DIM_Y_ICONS = 86;

}
