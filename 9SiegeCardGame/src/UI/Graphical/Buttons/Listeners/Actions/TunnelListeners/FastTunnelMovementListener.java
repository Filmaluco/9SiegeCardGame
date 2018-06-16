package UI.Graphical.Buttons.Listeners.Actions.TunnelListeners;

import Controllers.ObservableGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static SiegeCard.Util.Constants.AUTO_MOVMENT;
import static SiegeCard.Util.Constants.FAST_MOVEMENT;

public class FastTunnelMovementListener implements ActionListener {
    ObservableGame game;

    public FastTunnelMovementListener(ObservableGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getActionPoints()>0) {
            game.Tunel();
            game.MoveInTunnel(FAST_MOVEMENT);
            game.ApplyRules(AUTO_MOVMENT);
        }
    }
}
