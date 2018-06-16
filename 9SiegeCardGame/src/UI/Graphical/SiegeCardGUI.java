package UI.Graphical;

import Controllers.ObservableGame;
import Controllers.SavesController;
import Controllers.states.GameSetup;
import UI.Graphical.MenuBar.MainMenuBar;
import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class SiegeCardGUI extends JFrame implements Observer, Constants, Miscellaneous {

    ObservableGame game;
    private SiegeCardPanel siegeCardPanel;
    private JMenuBar mainMenuBar;

    public SiegeCardGUI(ObservableGame game) {
        super("9SiegeCardGame");

        this.game = game;
        game.addObserver(this);

        setupComponents();

        setSize(DIM_X_FRAME,DIM_Y_FRAME);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    private void setupComponents() {
        mainMenuBar = new MainMenuBar(game, SiegeCardGUI.this);
        setJMenuBar(mainMenuBar);

        setLayout(new BorderLayout());
        siegeCardPanel = new SiegeCardPanel(game);
        add(siegeCardPanel, BorderLayout.CENTER);
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
