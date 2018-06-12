package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import Controllers.states.GameSetup;
import UI.Graphical.Buttons.TunnelViewButton;
import UI.Graphical.Rectangles.Enemies.TrebuchetGUI;
import UI.Graphical.Rectangles.EnemyGUI;
import UI.Graphical.Util.Constants;


import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EnemyTrackDisplay extends JPanel implements Observer, Constants{
    //TODO: CardLayout switch with panel if active
    ObservableGame game;
    private TrebuchetGUI trebuchetTracker;
    private EnemyGUI enemyGUI;
    private TunnelViewButton tunnelViewButton;

    public EnemyTrackDisplay(ObservableGame game) {
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

        this.setVisible(game.getState() instanceof ActionPhase);
    }

    private void setupComponents() {
        setLayout(new GridBagLayout());
        enemyGUI = new EnemyGUI(game);
        trebuchetTracker = new TrebuchetGUI(game);
        tunnelViewButton = new TunnelViewButton();
    }

    private void layoutComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        add(enemyGUI,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        add(trebuchetTracker, gbc);

        gbc.gridx=3;
        gbc.gridy=0;
        add(tunnelViewButton, gbc);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(!(game.getState() instanceof GameSetup));
    }
}
