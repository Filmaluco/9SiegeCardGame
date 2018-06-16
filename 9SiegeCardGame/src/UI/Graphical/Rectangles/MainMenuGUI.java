package UI.Graphical.Rectangles;

import Controllers.GameController;
import Controllers.ObservableGame;
import Controllers.SavesController;
import UI.Graphical.Buttons.Listeners.PlayMenuListener;
import UI.Graphical.Buttons.MenuButton;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenuGUI extends JPanel implements Constants, ActionListener {
    ObservableGame game;
    MenuButton play;
    MenuButton loadGame;

    public MainMenuGUI(ObservableGame game) {
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
        loadGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser("./data");
        int returnVal = fc.showOpenDialog(getParent());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try{
                game.setGameController((GameController) SavesController.loadGameFromFile(file));
            }catch(IOException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(getParent(), "Operation failed: \r\n\r\n" + e);
            }

        } else {
            System.out.println("Operation canceled ");
        }
    }
}
