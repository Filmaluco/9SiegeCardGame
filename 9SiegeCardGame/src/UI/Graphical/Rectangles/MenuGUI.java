package UI.Graphical.Rectangles;

import Controllers.ObservableGame;
import UI.Graphical.Buttons.Listeners.PlayMenuListener;
import UI.Graphical.Buttons.MenuButton;
import UI.Graphical.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MenuGUI extends JPanel implements Constants {
    ObservableGame game;
    MenuButton play;
    MenuButton options;
    MenuButton loadGame;
    MenuButton exit;

    public MenuGUI(ObservableGame game) {
        this.game = game;

        Dimension d = new Dimension(DIM_X_MENU, DIM_Y_MENU);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setupComponents();
        layoutComponents();

        setBackground(Color.lightGray);
    }

    private void setupComponents(){
        play = new MenuButton("Play Game");
        options = new MenuButton("Options");
        loadGame = new MenuButton("Load Game");
        exit = new MenuButton("Exit");
    }

    private void layoutComponents() {
        add(play);
        add(options);
        add(loadGame);
        add(exit);
        play.addActionListener(new PlayMenuListener(game));



    }



}
