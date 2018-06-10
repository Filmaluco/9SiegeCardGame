package UI.Graphical.Rectangles;

import Controllers.ObservableGame;
import UI.Graphical.Buttons.Listeners.PlayMenuListener;
import UI.Graphical.Buttons.MenuButton;
import UI.Graphical.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class MenuGUI extends JPanel implements Constants {
    ObservableGame game;
    MenuButton play;
    MenuButton loadGame;

    public MenuGUI(ObservableGame game) {
        this.game = game;

        Dimension d = new Dimension(DIM_X_MENU, DIM_Y_MENU);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setLayout(new GridBagLayout());

        setupComponents();
        layoutComponents();
    }

    private void setupComponents(){
        play = new MenuButton("PLAY GAME ");
        loadGame = new MenuButton("LOAD GAME");
    }

    private void layoutComponents() {
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15,15,15,15);

        add(play, gbc);
        play.addActionListener(new PlayMenuListener(game));
        add(loadGame, gbc);
    }

}
