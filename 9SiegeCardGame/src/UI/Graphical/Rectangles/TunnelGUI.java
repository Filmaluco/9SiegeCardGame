package UI.Graphical.Rectangles;

import Controllers.ObservableGame;
import SiegeCard.Util.Rolls;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCircleCombatLabel;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCloseCombatLabel;
import UI.Graphical.Labels.Enemies.BatteringRam.BatteringRamCombatLabel;
import UI.Graphical.Labels.PlayerTracker.Tunnel.CastleLabel;
import UI.Graphical.Labels.PlayerTracker.Tunnel.EnemyLabel;
import UI.Graphical.Labels.PlayerTracker.Tunnel.TunnelLabel;
import UI.Graphical.Rectangles.Enemies.MouseListeners.EnemySelect;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyModel.MAX_ENEMY_TRACK_SLOTS;
import static Models.TunnelModel.TUNEL_SIZE;

public class TunnelGUI extends JPanel implements Observer, Constants {
    ObservableGame game;

    public TunnelGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_ICONS * 6,DIM_Y_ENEMY);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        //setLayout(new GridLayout(0,5,5,10));
        setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
    }

    //See if repaint works on components
    private void setupComponents() {
        add(new CastleLabel(game));
        for (int i = 1; i <= TUNEL_SIZE ; i++) {
            add(new TunnelLabel(game,i));
        }
        add(new EnemyLabel(game));
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
