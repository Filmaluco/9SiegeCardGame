package UI.Graphical.Rectangles.Enemies;

import Controllers.ObservableGame;
import UI.Graphical.Constants;
import UI.Graphical.Labels.Enemies.TrebuchetLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static Models.EnemyTrackerModel.MAX_TREBUCHET;

public class TrebuchetGUI extends JPanel implements Observer ,Constants{

    ObservableGame game;
    //TODO: Use if repaint doesnt work
    private int trebuchetCount;

    public TrebuchetGUI(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        this.trebuchetCount = game.getTrebuchetCount();

        Dimension d = new Dimension(DIM_X_TREBUCHET_GUI, 300);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();

        setLayout(new GridLayout(3,0,5,10));
    }

    //See if repaint works on components
    private void setupComponents() {
        for (int i = MAX_TREBUCHET; i > 0 ; i--) {
            add(new TrebuchetLabel(game, i));
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO: Test to check if it is necessary
        repaint();
    }
}
