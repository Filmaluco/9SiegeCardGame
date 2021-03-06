package UI.Graphical.Containers;

import Controllers.ObservableGame;
import Controllers.states.ActionPhase;
import UI.Graphical.Buttons.Actions.*;
import UI.Graphical.Buttons.Actions.TunnelMovement.TunnelMovementButton;
import UI.Graphical.Util.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class EnemyActionsDisplay extends JPanel implements Observer, Constants{

    ObservableGame game;
    private ArchersAttackButton archersAttackButton;
    private BoilAttackButton boilAttackButton;
    private CloseCombatAttackButton closeCombatAttackButton;
    private CoupureActionButton coupureActionButton;
    private RallyTroopsActionButton rallyTroopsActionButton;
    private TunnelMovementButton tunnelMovementButton;
    private SabotageActionButton sabotageActionIconButton;
    private SupplyRaidActionButton supplyRaidActionButton;
    private AdditionalPointIconsButton additionalPointActionButton;

    public EnemyActionsDisplay(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(DIM_X_FRAME,DIM_Y_ICONS);

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
        archersAttackButton = new ArchersAttackButton(game);
        boilAttackButton = new BoilAttackButton(game);
        closeCombatAttackButton = new CloseCombatAttackButton(game);
        coupureActionButton = new CoupureActionButton(game);
        rallyTroopsActionButton = new RallyTroopsActionButton(game);
        tunnelMovementButton = new TunnelMovementButton(game);
        sabotageActionIconButton = new SabotageActionButton(game);
        supplyRaidActionButton = new SupplyRaidActionButton(game);
        additionalPointActionButton = new AdditionalPointIconsButton(game);
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(archersAttackButton, gbc);
        gbc.gridx = 1;
        add(boilAttackButton, gbc);
        gbc.gridx = 2;
        add(closeCombatAttackButton, gbc);
        gbc.gridx = 3;
        add(coupureActionButton, gbc);
        gbc.gridx = 4;
        add(rallyTroopsActionButton, gbc);
        gbc.gridx = 5;
        add(tunnelMovementButton, gbc);
        gbc.gridx = 6;
        add(sabotageActionIconButton, gbc);
        gbc.gridx = 7;
        add(supplyRaidActionButton, gbc);
        gbc.gridx = 8;
        add(additionalPointActionButton, gbc);
    }

    @Override
    public void update(Observable o, Object arg) { }
}
