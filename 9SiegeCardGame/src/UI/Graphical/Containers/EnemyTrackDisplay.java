package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import UI.Graphical.Rectangles.Enemies.TrebuchetGUI;
import UI.Graphical.Rectangles.EnemyGUI;


import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EnemyTrackDisplay extends JPanel implements Observer{
    //TODO: CardLayout switch with panel if active
    ObservableGame game;
    private TrebuchetGUI trebuchetTracker;
    private EnemyGUI enemyGUI;

    public EnemyTrackDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(600,350);

        setSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setOpaque(false);

        setupComponents();
        layoutComponents();

        this.setVisible(game.getState() instanceof ActionPhase);
    }

    private void setupComponents() {
        setLayout(new GridBagLayout());
        enemyGUI = new EnemyGUI(game);
        trebuchetTracker = new TrebuchetGUI(game);
    }

    private void layoutComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        add(enemyGUI,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        add(trebuchetTracker, gbc);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof ActionPhase);
    }
}
