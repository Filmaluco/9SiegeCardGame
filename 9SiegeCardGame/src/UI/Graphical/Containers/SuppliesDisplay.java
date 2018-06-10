package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Constants;
import UI.Graphical.Labels.MoraleLabel;
import UI.Graphical.Labels.SuppliesLabel;
import UI.Graphical.Labels.WallLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SuppliesDisplay extends JPanel implements Observer,Constants{
    ObservableGame game;
    MoraleLabel moraleLabel;
    WallLabel wallLabel;
    SuppliesLabel suppliesLabel;

    public SuppliesDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_SUPPLIES, DIM_Y_SUPPLIES);
        setSize(d);
        setMinimumSize(d);
        setPreferredSize(d);
        setMaximumSize(d);

        this.setVisible(!(game.getState() instanceof GameSetup));
        setupComponents();
        layoutComponents();
    }

    private void setupComponents() {
        moraleLabel = new MoraleLabel(game, game.getMorale());
        wallLabel = new WallLabel(game, game.getWallStrenght());
        suppliesLabel = new SuppliesLabel(game, game.getSupplies());
    }

    private void layoutComponents() {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0,DIM_Y_STATUS_TRACK_BORDER));
        add(moraleLabel);
        add(wallLabel);
        add(suppliesLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        moraleLabel.setAmount(game.getMorale());
        wallLabel.setAmount(game.getWallStrenght());
        suppliesLabel.setAmount(game.getSupplies());
        this.setVisible(!(game.getState() instanceof GameSetup));
    }
}
