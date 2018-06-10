package UI.Graphical.Buttons.Listeners;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuListener implements ActionListener{

    ObservableGame game;

    public PlayMenuListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: Check Initial Condition and change name with a popup
        game.setInitialConfig("Ricardo");
        game.Start();
    }

}
