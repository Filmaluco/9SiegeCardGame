package UI.Graphical.Buttons.Listeners;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBoilAttackListener implements ActionListener{
    ObservableGame game;

    public ActionBoilAttackListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) { game.BoilingAttack(); }
}
