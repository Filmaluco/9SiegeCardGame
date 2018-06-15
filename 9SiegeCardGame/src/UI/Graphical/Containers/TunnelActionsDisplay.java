package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.Actions.AdditionalPointIconsButton;
import UI.Graphical.Buttons.Actions.SabotageActionButton;
import UI.Graphical.Buttons.Actions.SupplyRaidActionButton;
import UI.Graphical.Buttons.Actions.TunnelMovement.FastTunnelMovementButton;
import UI.Graphical.Buttons.Actions.TunnelMovement.FreeTunnelMovementButton;
import UI.Graphical.Buttons.Actions.TunnelMovement.TunnelMovementButton;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TunnelActionsDisplay extends JPanel implements Observer, Constants {

    ObservableGame game;

    private TunnelMovementButton tunnelMovementButton;
    private FreeTunnelMovementButton freeTunnelMovementButton;
    private FastTunnelMovementButton fastTunnelMovementButton;
    private SabotageActionButton sabotageActionButton;
    private AdditionalPointIconsButton additionalPointIconsButton;
    private SupplyRaidActionButton supplyRaidActionButton;

    public TunnelActionsDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(800,DIM_Y_ICONS);

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
        tunnelMovementButton = new TunnelMovementButton(game);
        freeTunnelMovementButton = new FreeTunnelMovementButton(game);
        fastTunnelMovementButton = new FastTunnelMovementButton(game);
        sabotageActionButton = new SabotageActionButton(game);
        additionalPointIconsButton = new AdditionalPointIconsButton(game);
        supplyRaidActionButton = new SupplyRaidActionButton(game);
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(tunnelMovementButton, gbc);
        gbc.gridx = 1;
        add(freeTunnelMovementButton, gbc);
        gbc.gridx = 2;
        add(fastTunnelMovementButton, gbc);
        gbc.gridx = 3;
        add(sabotageActionButton, gbc);
        gbc.gridx = 4;
        add(supplyRaidActionButton, gbc);
        gbc.gridx = 5;
        add(additionalPointIconsButton, gbc);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
