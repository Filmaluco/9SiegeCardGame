package UI.Graphical.Buttons.Listeners.Actions;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionArchersAttackListener implements ActionListener{
    ObservableGame game;

    public ActionArchersAttackListener(ObservableGame game) { this.game = game; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0)
            game.ArchersAttack();
    }
}
