package UI.Graphical.Containers.Switch;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Buttons.EnemyTrackerViewButton;
import UI.Graphical.Buttons.Listeners.EnemySwitchListener;
import UI.Graphical.Buttons.Listeners.TunnelSwitchListener;
import UI.Graphical.Buttons.TunnelViewButton;
import UI.Graphical.Containers.EnemyTrackDisplay;
import UI.Graphical.Containers.TunnelDisplay;
import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TrackSwitchDisplay extends JPanel implements Observer,Constants, Miscellaneous {
    private ObservableGame game;

    private EnemyTrackDisplay enemyTrackDisplay;
    private TunnelDisplay tunnelDisplay;

    public TrackSwitchDisplay(ObservableGame game) {
        this.game = game;

        setOpaque(false);
        setLayout(new CardLayout());

        setupComponents();

        setSize(DIM_X_ENEMY_GUI,DIM_Y_ENEMY_GUI);
    }

    private void setupComponents() {
        enemyTrackDisplay = new EnemyTrackDisplay(game);
        tunnelDisplay = new TunnelDisplay(game);

        add(enemyTrackDisplay, ENEMY_TRACKER);
        add(tunnelDisplay, TUNNEL_TRACKER);
    }

    public CardLayout getTrackSwitchDisplayLayout() { return (CardLayout)this.getLayout(); }
    public EnemyTrackDisplay getEnemyTrackDisplay() { return enemyTrackDisplay; }
    public TunnelDisplay getTunnelDisplay() { return tunnelDisplay; }


    @Override
    public void update(Observable o, Object arg) {

    }
}
