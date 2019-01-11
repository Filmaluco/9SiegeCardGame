package UI.Graphical.Containers.Switch;

import Controllers.ObservableGame;
import Controllers.states.GameSetup;
import UI.Graphical.Containers.EnemyActionsDisplay;
import UI.Graphical.Containers.TunnelActionsDisplay;
import UI.Graphical.Util.Constants;
import UI.Graphical.Util.Miscellaneous;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ActionsSwitchDisplay extends JPanel implements Observer,Constants, Miscellaneous {
    private ObservableGame game;

    private EnemyActionsDisplay enemyActionsDisplay;
    private TunnelActionsDisplay tunnelActionsDisplay;

    public ActionsSwitchDisplay(ObservableGame game) {
        this.game = game;

        setOpaque(false);
        setLayout(new CardLayout());

        setupComponents();

        setSize(DIM_X_ENEMY_GUI,DIM_Y_ENEMY_GUI);
    }

    private void setupComponents() {
        enemyActionsDisplay = new EnemyActionsDisplay(game);
        tunnelActionsDisplay = new TunnelActionsDisplay(game);

        add(enemyActionsDisplay, ENEMY_TRACKER);
        add(tunnelActionsDisplay, TUNNEL_TRACKER);
    }

    public CardLayout getActionsSwitchDisplayLayout() { return (CardLayout)this.getLayout();}
    public EnemyActionsDisplay getEnemyActionsDisplay() { return enemyActionsDisplay; }
    public TunnelActionsDisplay getTunnelActionsDisplay() { return tunnelActionsDisplay; }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(!(game.getState() instanceof GameSetup));
    }
}
