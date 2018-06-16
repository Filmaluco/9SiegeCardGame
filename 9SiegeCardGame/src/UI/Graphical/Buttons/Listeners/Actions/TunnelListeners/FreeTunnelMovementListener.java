package UI.Graphical.Buttons.Listeners.Actions.TunnelListeners;

import Controllers.ObservableGame;
import SiegeCard.Util.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static SiegeCard.Util.Constants.FREE_MOVEMENT;

public class FreeTunnelMovementListener implements ActionListener {
    ObservableGame game;

    public FreeTunnelMovementListener(ObservableGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0) {
            game.Tunel();
            game.MoveInTunnel(FREE_MOVEMENT);
        }
    }
}
