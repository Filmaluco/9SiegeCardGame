package UI.Graphical.Buttons.Listeners.Actions;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextTurnListener implements ActionListener{
    ObservableGame game;

    public NextTurnListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.EndTurn();
    }
}
