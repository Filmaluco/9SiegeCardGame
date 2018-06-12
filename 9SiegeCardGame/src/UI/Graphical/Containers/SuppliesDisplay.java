package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Util.Constants;
import UI.Graphical.Labels.PlayerTracker.MoraleLabel;
import UI.Graphical.Labels.PlayerTracker.SuppliesLabel;
import UI.Graphical.Labels.PlayerTracker.WallLabel;

import javax.swing.*;
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
        setLayout(new FlowLayout(FlowLayout.LEFT,0,2));
        //setLayout(new GridLayout(3,0));
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
