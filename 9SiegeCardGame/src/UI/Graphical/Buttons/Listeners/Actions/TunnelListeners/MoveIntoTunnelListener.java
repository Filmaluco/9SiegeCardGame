package UI.Graphical.Buttons.Listeners.Actions.TunnelListeners;

import Controllers.ObservableGame;
import SiegeCard.Util.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveIntoTunnelListener implements ActionListener {
    ObservableGame game;

    public MoveIntoTunnelListener(ObservableGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0) {
            game.Tunel();
            game.MoveIntoTunnel();
            game.ApplyRules(Constants.AUTO_MOVMENT);
        }
    }
}
