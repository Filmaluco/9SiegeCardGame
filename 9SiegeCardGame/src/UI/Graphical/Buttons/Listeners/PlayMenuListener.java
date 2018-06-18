package UI.Graphical.Buttons.Listeners;

import Controllers.ObservableGame;
import UI.Graphical.DialogBox.DialogBox;
import UI.Graphical.DialogBox.DialogBoxFrame;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuListener implements ActionListener, Miscellaneous{

    ObservableGame game;
    String playerName;

    public PlayMenuListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        do {
            playerName = (String) JOptionPane.showInputDialog(
                    new DialogBoxFrame(),
                    DIALOG_BOX_PLAYER_NAME_TEXT,
                    DIALOG_BOX_PLAYER_NAME_MENU,
                    JOptionPane.PLAIN_MESSAGE);
        } while (playerName.length()<1 || playerName.length()>18);
        game.setInitialConfig(playerName);
        game.Start();
    }

}
