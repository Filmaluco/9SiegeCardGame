package UI.Graphical.Buttons.Listeners;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCoupureListener implements ActionListener {
    ObservableGame game;

    public ActionCoupureListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) { game.Coupure(); }
}
