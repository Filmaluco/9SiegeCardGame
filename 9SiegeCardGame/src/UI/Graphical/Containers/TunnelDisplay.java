package UI.Graphical.Containers;

import Controllers.ObservableGame;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TunnelDisplay extends JPanel implements Observer ,Constants{
    ObservableGame game;

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

    }

    private void layoutComponents() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
