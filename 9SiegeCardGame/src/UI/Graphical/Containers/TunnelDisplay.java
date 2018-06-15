package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Buttons.Actions.NextTurnButton;
import UI.Graphical.Labels.PlayerTracker.Tunnel.CastleLabel;
import UI.Graphical.Rectangles.RaidedSuppliesGUI;
import UI.Graphical.Rectangles.TunnelGUI;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TunnelDisplay extends JPanel implements Observer ,Constants{
    ObservableGame game;
    TunnelGUI tunnelGUI;
    RaidedSuppliesGUI raidedSuppliesGUI;

    public TunnelDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_ENEMY_GUI,DIM_Y_ENEMY_GUI);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();
        layoutComponents();
    }

    private void setupComponents() {
        setLayout(new GridBagLayout());
        tunnelGUI = new TunnelGUI(game);
        raidedSuppliesGUI = new RaidedSuppliesGUI(game);
    }

    private void layoutComponents() {
        add(tunnelGUI);
        add(raidedSuppliesGUI);
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
