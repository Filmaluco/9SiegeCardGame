package UI.Graphical.Rectangles;

import Controllers.ObservableGame;
import UI.Graphical.Labels.Enemies.TrebuchetLabel;
import UI.Graphical.Labels.PlayerTracker.RaidedSuppliesLabel;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyTrackerModel.MAX_TREBUCHET;
import static Models.TunnelModel.MAX_RAIDED_SUPPLIES;

public class RaidedSuppliesGUI extends JPanel implements Observer, Constants {

    ObservableGame game;

    public RaidedSuppliesGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_ICONS+50, 200);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        setLayout(new FlowLayout(FlowLayout.CENTER,20,DIM_Y_TREBUCHET_BORDER));
    }

    //See if repaint works on components
    private void setupComponents() {
        for (int i = MAX_RAIDED_SUPPLIES; i > 0 ; i--)
            add(new RaidedSuppliesLabel(game, i));
    }

    @Override
    public void update(Observable o, Object arg) { }
}
